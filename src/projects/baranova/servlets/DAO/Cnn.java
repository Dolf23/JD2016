package projects.baranova.servlets.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс с параметрами подключения к серверу MySQL
 * Пожалуйста используйте его для подключения к серверу.
 * Это позволит проверять ваши работы.
 * Можно использовать собственные настройки для
 * подключения
 */
public class Cnn {

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        //стандартный порт 3306
        final String URL3306 = "jdbc:mysql://127.0.0.1:3306/Hotel"
        /*добавим UTF-8*/    + "?useUnicode=true&characterEncoding=UTF-8";
        try {
            //для надежного определения сторонней библиотеки на Tomcat
            //добавим поиск подходящего драйвера для mysql
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL3306, USER, PASSWORD);
    }
}
