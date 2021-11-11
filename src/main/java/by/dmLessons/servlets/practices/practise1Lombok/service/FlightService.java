package by.dmLessons.servlets.practices.practise1Lombok.service;


import by.dmLessons.servlets.practices.practise1Lombok.dao.FlightDao;
import by.dmLessons.servlets.practices.practise1Lombok.dto.FlightDto;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    private static final FlightService INSTANCE = new FlightService();

    private final FlightDao flightDao = FlightDao.getInstance();    // FlightService зависит от FlightDao

    private FlightService() {
    }

    public List<FlightDto> findAll() {
        return flightDao.findAll()
                .stream()
                .map(flight -> FlightDto.builder()
                        .id(flight.getId())
                        .description(
                        """
                            %s -> %s :  %s
                        """.formatted(flight.getDepartureAirport(), flight.getArrivalAirport(), flight.getStatus()))
                        .build())
                .collect(Collectors.toList());
    }
    public static FlightService getInstance() {
        return INSTANCE;
    }
}
