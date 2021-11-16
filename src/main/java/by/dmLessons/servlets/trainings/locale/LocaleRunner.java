package by.dmLessons.servlets.trainings.locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleRunner {

    public static void main(String[] args) {

        Locale locale = new Locale("ru", "RU");
        System.out.println(Locale.getDefault());

        var translations1 = ResourceBundle.getBundle("translations");
        var translations2 = ResourceBundle.getBundle("translations", locale);

        System.out.println(translations1.getString("password"));
        System.out.println(translations2.getString("password"));
        var keys1 = translations1.getKeys();
        while (keys1.hasMoreElements()) {
            System.out.println(keys1.nextElement());
        }
        var keys2 = translations2.getKeys();
        while (keys2.hasMoreElements()) {
            System.out.println(keys2.nextElement());
        }

    }
}
