package by.it.daylidovich.JD03_01.C;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CN {
    public static final String USER_DB = "root";
    public static final String PASSWORD_DB = "";

    public static Connection getConnection() throws SQLException {
        final String URL = "jdbc:mysql://localhost:2016/it_academy" + "?useUnicode=true&characterEncoding=UTF-8";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
        return DriverManager.getConnection(URL, USER_DB, PASSWORD_DB);
    }
}
