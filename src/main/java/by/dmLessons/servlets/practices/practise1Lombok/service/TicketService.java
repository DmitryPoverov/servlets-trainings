package by.dmLessons.servlets.practices.practise1Lombok.service;

import by.dmLessons.servlets.practices.practise1Lombok.dao.TicketDao;
import by.dmLessons.servlets.practices.practise1Lombok.dto.TicketDto;
import java.util.List;
import java.util.stream.Collectors;

public class TicketService {

    private static final TicketService INSTANCE = new TicketService();

    private final TicketDao ticketDao = TicketDao.getInstance();

    private TicketService() {}

    public List<TicketDto> findAllByFlightId(Long flightId) {
        return ticketDao.findByFlightId(flightId)
                .stream()
                .map(ticket -> TicketDto.builder()
                        .ticketId(ticket.getTicketId())
                        .flightId(ticket.getFlightId())
                        .seatNo(ticket.getSeatNo())
                        .build())
                .collect(Collectors.toList());
    }

    public static TicketService getInstance() {
        return INSTANCE;
    }
}
