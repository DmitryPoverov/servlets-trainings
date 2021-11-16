package by.dmLessons.servlets.trainings.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JspHelper {

// Чтобы не писать весь путь целиком, а только имя файла, создаем этот класс, который возвращает весь путь с префиксом.
    private static final String JSP_FORMAT = "/WEB-INF/jsp/%s.jsp";

    public static String getPath (String jspName) {
        return String.format(JSP_FORMAT, jspName);
    }

}
