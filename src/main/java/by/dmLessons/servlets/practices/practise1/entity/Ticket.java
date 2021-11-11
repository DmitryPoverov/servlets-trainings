package by.dmLessons.servlets.practices.practise1.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Ticket {

    private Long ticketId;
    private String passengerNo;
    private String passengerName;
    private Long flightId;
    private String seatNo;
    private BigDecimal cost;

    public Ticket(Long ticketId, String passengerNo, String passengerName, Long flightId, String seatNo, BigDecimal cost) {
        this.ticketId = ticketId;
        this.passengerNo = passengerNo;
        this.passengerName = passengerName;
        this.flightId = flightId;
        this.seatNo = seatNo;
        this.cost = cost;
    }

    public Long getTicketId() {
        return ticketId;
    }
    public String getPassengerNo() {
        return passengerNo;
    }
    public String getPassengerName() {
        return passengerName;
    }
    public Long getFlightId() {
        return flightId;
    }
    public String getSeatNo() {
        return seatNo;
    }
    public BigDecimal getCost() {
        return cost;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }
    public void setPassengerNo(String passengerNo) {
        this.passengerNo = passengerNo;
    }
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(ticketId, ticket.ticketId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId);
    }

    @Override
    public String toString() {
        return "Ticket [ticketId:" + ticketId + ", passengerNo:" + passengerNo + ", passengerName: "
               + passengerName + ", flightId:" + flightId + ", seatNo:" + seatNo + ", cost:" + cost + ']';
    }
}
