package by.dmLessons.servlets.practices.practise1Lombok.entity;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Flight {
    Long id;
    String flightNo;
    LocalDateTime departureDate;
    String departureAirport;
    LocalDateTime arrivalDate;
    String arrivalAirport;
    Integer aircraftId;
    FlightStatus status;

}
