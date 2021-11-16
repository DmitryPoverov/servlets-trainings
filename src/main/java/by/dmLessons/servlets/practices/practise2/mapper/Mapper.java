package by.dmLessons.servlets.practices.practise2.mapper;

public interface Mapper<F, T> {

    T mapFrom (F object);
}
