package by.dmLessons.servlets.practices.practise1Lombok.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TicketDto {

    Long ticketId;
    Long flightId;
    String seatNo;

}
