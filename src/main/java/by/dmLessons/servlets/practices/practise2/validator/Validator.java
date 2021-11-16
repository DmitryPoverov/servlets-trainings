package by.dmLessons.servlets.practices.practise2.validator;

public interface Validator <T>{

     ValidationResult isValid(T object);
}
