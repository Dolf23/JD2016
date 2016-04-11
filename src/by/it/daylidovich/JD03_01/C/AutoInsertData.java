package by.it.daylidovich.JD03_01.C;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AutoInsertData {
    public static void main(String[] args) {
        try(Connection connection  =  CN.getConnection();
            Statement statement = connection.createStatement()) {

            //добавление записей в таблицы
            CreatingUtils.insertDataToTables(statement);
            System.out.println("Rows added.");

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
