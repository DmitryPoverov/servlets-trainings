package by.dmLessons.servlets.practices.practise1Lombok.dto;

import lombok.*;

@Value
@Builder
public class FlightDto {

    Long id;
    String description;

}
