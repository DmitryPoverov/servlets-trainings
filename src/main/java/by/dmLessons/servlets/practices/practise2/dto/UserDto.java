package by.dmLessons.servlets.practices.practise2.dto;

import by.dmLessons.servlets.practices.practise2.entity.Gender;
import by.dmLessons.servlets.practices.practise2.entity.Role;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class UserDto {
    Integer id;
    String name;
    LocalDate birthday;
    String email;
    Role role;
    Gender gender;
}
