package by.dmLessons.servlets.practices.practise2.mapper;

import by.dmLessons.servlets.practices.practise2.dto.CreateUserDto;
import by.dmLessons.servlets.practices.practise2.entity.Gender;
import by.dmLessons.servlets.practices.practise2.entity.Role;
import by.dmLessons.servlets.practices.practise2.entity.User;
import by.dmLessons.servlets.practices.practise2.util.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDto, User> {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .role(Role.valueOf(object.getRole()))
                .gender(Gender.valueOf(object.getGender()))
                .build();
    }


    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }
}
