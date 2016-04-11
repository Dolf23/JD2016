package by.it.daylidovich.JD03_01.C;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Autocreate_DB {
    public static void main(String[] args) {
        try(Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement()) {
            //создание таблицы
            CreatingUtils.createTable(statement);
            System.out.println("Tables created.");

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
