package by.dmLessons.servlets.practices.practise1.dto;

import java.util.Objects;

public class TicketDto {

    private final Long ticketId;
    private final Long flightId;
    private final String seatNo;

    public TicketDto(Long ticketId, Long flightId, String seatNo) {
        this.ticketId = ticketId;
        this.flightId = flightId;
        this.seatNo = seatNo;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketDto ticketDto = (TicketDto) o;
        return Objects.equals(ticketId, ticketDto.ticketId) && Objects.equals(flightId, ticketDto.flightId) && Objects.equals(seatNo, ticketDto.seatNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, flightId, seatNo);
    }

    @Override
    public String toString() {
        return "TicketDto [ticketId:" + ticketId + ", flightId:" + flightId + ", seatNo:" + seatNo + ']';
    }
}
