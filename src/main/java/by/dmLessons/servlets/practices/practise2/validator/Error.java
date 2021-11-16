package by.dmLessons.servlets.practices.practise2.validator;

import lombok.Value;

@Value(staticConstructor = "of")
public class Error {
    String code;
    String message;

}
