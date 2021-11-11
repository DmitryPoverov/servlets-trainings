package by.dmLessons.servlets.practices.practise1Lombok.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
public class ConnectionManager {

    public static final String URL_KEY = "db.url";
    public static final String URL_USER = "db.user";
    public static final String URL_PASSWORD = "db.password";

    static {
        loadDriver();
    }

    @SneakyThrows
    private static void loadDriver() {
        Class.forName("org.postgresql.Driver");
    }

    @SneakyThrows
    public static Connection get() {
        return DriverManager.getConnection(
                PropertiesUtil.get(URL_KEY),
                PropertiesUtil.get(URL_USER),
                PropertiesUtil.get(URL_PASSWORD));
    }

}

