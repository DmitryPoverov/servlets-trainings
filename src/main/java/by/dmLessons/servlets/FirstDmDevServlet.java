package by.dmLessons.servlets;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/first")
public class FirstDmDevServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            var header = headerNames.nextElement();
            System.out.println(header);
            System.out.println(req.getHeader(header) + "\n");
        }
        resp.setContentType("text/html; charset=UTF-8");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (var writer = resp.getWriter()) {
            writer.write("<h2>Hello from first DmDev servlet!!! Привет с первого сервлета!!!</h2>");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
