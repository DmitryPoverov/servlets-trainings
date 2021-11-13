package by.dmLessons.servlets.trainings;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/cookies")
public class CookieServlet extends HttpServlet {

    private static final String UNIQUE_ID = "userId";
    private final AtomicInteger counter = new AtomicInteger();  // Данный класс потокобезопасен.

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var cookies = req.getCookies();
        if (cookies == null || Arrays.stream(cookies)
                                        .filter(cookie -> UNIQUE_ID.equals(cookie.getName()))
                                        .findFirst()
                                        .isEmpty()) {
            var cookie = new Cookie(UNIQUE_ID, "1");
            cookie.setPath("/cookies");
            cookie.setMaxAge(60*15);   // время жизни cookie (в сек.), по-умолчанию: -1 (удалить с закрытием браузера)
// т.к. мы в ответе с сервера отправляем наши куки, то в resp добавляем cookie
            resp.addCookie(cookie);
            counter.incrementAndGet();
        }
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (var writer = resp.getWriter()) {

// не работает, так, как я хочу: нужно разбираться.
            var s = String.valueOf(counter.get());
            writer.write("<h1>Counter Счетчик:</h1>" + s);
        }
    }
}
