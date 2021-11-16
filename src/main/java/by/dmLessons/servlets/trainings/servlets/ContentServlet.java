package by.dmLessons.servlets.trainings.servlets;

import by.dmLessons.servlets.practices.practise1Lombok.service.FlightService;
import by.dmLessons.servlets.practices.practise1Lombok.dto.FlightDto;
import by.dmLessons.servlets.trainings.utils.JspHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<FlightDto> flightDtos = flightService.findAll();
        req.setAttribute("flights", flightDtos);

        req.getSession().setAttribute("flightsMap", flightDtos.stream()
                .collect(Collectors.toMap(FlightDto::getId, FlightDto::getDescription)));

        req.getRequestDispatcher(JspHelper.getPath("content")).forward(req, resp);
    }
}
