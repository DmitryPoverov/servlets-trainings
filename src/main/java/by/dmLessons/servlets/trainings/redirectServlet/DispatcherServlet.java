package by.dmLessons.servlets.trainings.redirectServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

/* этот код на forward запроса
        req.getRequestDispatcher("/flights-lombok")
                .forward(req, resp);
// перенаправить можно через контекст сервлета:
        getServletContext().getRequestDispatcher("/flights").forward(req, resp);
        System.out.println();*/

/* этот код на include запроса
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        req.getRequestDispatcher("/flight-for-dispatcher")
                .include(req, resp);
        var writer = resp.getWriter();
        writer.write("<h1>A text from a .../dispatcher servlet</h1>");*/

        resp.sendRedirect("/flight-for-dispatcher");
    }
}
