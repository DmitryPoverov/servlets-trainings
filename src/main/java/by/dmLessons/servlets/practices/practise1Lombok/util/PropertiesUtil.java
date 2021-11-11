package by.dmLessons.servlets.practices.practise1Lombok.util;

import lombok.SneakyThrows;

import java.util.Properties;

public class PropertiesUtil {

    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    @SneakyThrows
    private static void loadProperties() {
        try (var inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        }
    }

    private PropertiesUtil(){
    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }

}
