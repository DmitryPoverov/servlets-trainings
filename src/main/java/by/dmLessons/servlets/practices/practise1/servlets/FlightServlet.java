package by.dmLessons.servlets.practices.practise1.servlets;

import by.dmLessons.servlets.practices.practise1.service.FlightService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (var printWriter = resp.getWriter()) {
            printWriter.write("<h1>Список перелетов:</h1>");
            printWriter.write("<ul>");
            flightService.findAll().forEach(flightDto -> {
                printWriter.write("""
                        <li>
                            <a href="/tickets?flightId=%d">%s</a>
                        </li>
                        """.formatted(flightDto.getId(), flightDto.getDescription()));
            });
            printWriter.write("</ul>");
        }
    }

/*    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try(PrintWriter printWriter = resp.getWriter()) {
            printWriter.write("<h1>Список перелетов:</h1>");
            printWriter.write("<ul>");
            flightService.findAll().forEach(flightDto -> {
                printWriter.write(String.format("<li> \n <a href=\"/tickets?flightId=%d\">%s</a> \n </li>", flightDto.getId(), flightDto.getDescription()));
            });
            printWriter.write("</ul>");
        }
    }*/

}
