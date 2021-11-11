package by.dmLessons.servlets.practices.practise1Lombok.entity;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class Ticket {

    Long ticketId;
    String passengerNo;
    String passengerName;
    Long flightId;
    String seatNo;
    BigDecimal cost;

}
