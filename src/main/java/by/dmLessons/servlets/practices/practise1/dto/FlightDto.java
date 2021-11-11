package by.dmLessons.servlets.practices.practise1.dto;

import java.util.Objects;

public class FlightDto {
    private final Long id;            // эти поля будут immutable и поэтому делаем только getters
    private final String description; // в нем указываем откуда/куда летит самолет и его статус

    public FlightDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }

        public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightDto flightDto = (FlightDto) o;
        return Objects.equals(id, flightDto.id) && Objects.equals(description, flightDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "FlightDto{" +
               "id=" + id +
               ", description='" + description + '\'' +
               '}';
    }
}
