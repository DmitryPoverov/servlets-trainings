package by.dmLessons.servlets.practices.practise1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {

    public static final String URL_KEY = "db.url";
    public static final String URL_USER = "db.user";
    public static final String URL_PASSWORD = "db.password";

    static {
        loadDriver();
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // т.к. класс утилитный, мы не должны создавать его экземпляры, для этого конструктор - приватный
    private ConnectionManager() {
    }

    public static Connection get() {
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(URL_USER),
                    PropertiesUtil.get(URL_PASSWORD));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

