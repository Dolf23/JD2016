package by.it.daylidovich.JD03_02.A_crud;

import by.it.daylidovich.JD03_01.C.CN;

import java.sql.*;

public class CRUD_Type_action {
    public static void read() throws SQLException {
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        System.out.println("Table Type action:");
        ResultSet resultSet=statement.executeQuery("SELECT * FROM type_action_d;");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Type_action");
            System.out.println(out);
        }
        connection.close();
    }

    public static void create(String typeAction) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO type_action_d(Type_action) VALUES ('" + typeAction + "')");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM type_action_d ORDER BY id DESC LIMIT 1");
        System.out.print("Added: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Type_action");
            System.out.println(out);
        }
        connection.close();
    }

    public static void update(int id, String typeAction) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE type_action_d SET Type_action='" + typeAction + "' WHERE id=" + id);
        ResultSet resultSet=statement.executeQuery("SELECT * FROM type_action_d WHERE id=" + id);
        System.out.print("Changed: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Type_action");
            System.out.println(out);
        }
        connection.close();
    }

    public static void delete(int id) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM type_action_d WHERE id=" + id);
        read();
        connection.close();
    }
}
