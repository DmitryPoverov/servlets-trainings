package by.dmLessons.servlets.practices.practise2.validator;

import by.dmLessons.servlets.practices.practise2.dto.CreateUserDto;
import by.dmLessons.servlets.practices.practise2.entity.Gender;
import by.dmLessons.servlets.practices.practise2.util.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDto> {

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        ValidationResult validationResult = new ValidationResult();
        if (!LocalDateFormatter.isValid(object.getBirthday())) {
             validationResult.add(Error.of("invalid.date", "Birthday is invalid"));
        }
        if (!Gender.find(object.getGender()).isPresent()) {
            validationResult.add(Error.of("invalid.gender", "Gender is invalid"));
        }
        return validationResult;
    }

    // Дописать валидацию для всех полей.

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }

}
