package by.dmLessons.servlets.practices.practise1.service;

import by.dmLessons.servlets.practices.practise1.dao.TicketDao;
import by.dmLessons.servlets.practices.practise1.dto.TicketDto;

import java.util.List;
import java.util.stream.Collectors;

public class TicketService {

    private static final TicketService INSTANCE = new TicketService();

    private final TicketDao ticketDao = TicketDao.getInstance();

    private TicketService() {}

    public List<TicketDto> findAllByFlightId(Long flightId) {
        return ticketDao.findByFlightId(flightId)
                .stream()
                .map(ticket -> new TicketDto(
                        ticket.getTicketId(),
                        ticket.getFlightId(),
                        ticket.getSeatNo()))
                .collect(Collectors.toList());
    }

    public static TicketService getInstance() {
        return INSTANCE;
    }
}
