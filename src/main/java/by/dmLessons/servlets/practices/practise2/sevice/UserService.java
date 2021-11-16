package by.dmLessons.servlets.practices.practise2.sevice;

import by.dmLessons.servlets.practices.practise2.dto.UserDto;
import by.dmLessons.servlets.practices.practise2.dao.UserDao;
import by.dmLessons.servlets.practices.practise2.dto.CreateUserDto;
import by.dmLessons.servlets.practices.practise2.entity.User;
import by.dmLessons.servlets.practices.practise2.exception.ValidationException;
import by.dmLessons.servlets.practices.practise2.mapper.CreateUserMapper;
import by.dmLessons.servlets.practices.practise2.mapper.UserMapper;
import by.dmLessons.servlets.practices.practise2.validator.CreateUserValidator;

import by.dmLessons.servlets.practices.practise2.validator.ValidationResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();

    public static UserService getInstance() {
        return INSTANCE;
    }

    public Optional<UserDto> login(String email, String password) {
        return userDao.findByEmailAndPassword(email, password)
                .map(object -> userMapper.mapFrom(object));
    }

/* 1-ый этап - валидация
 2-ой - преобразовать DTO в сущность
 3-ий - воспользоваться DAO, чтобы сохранить преобразованную сущность
 4-ый - возвращаем Id или саму сущность*/
    public Integer create(CreateUserDto userDto) {
        ValidationResult validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        User userEntity = createUserMapper.mapFrom(userDto);
        User save = userDao.save(userEntity);
        return save.getId();
    }
}
