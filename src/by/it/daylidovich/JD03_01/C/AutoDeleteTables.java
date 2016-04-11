package by.it.daylidovich.JD03_01.C;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AutoDeleteTables {
    public static void main(String[] args) {
        try(Connection connection  =  CN.getConnection();
            Statement statement = connection.createStatement()){
            CreatingUtils.deleteTable(statement);
            System.out.println("Table deleted.");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
