package by.it.daylidovich.JD03_02.A_crud;

import by.it.daylidovich.JD03_01.C.CN;

import java.sql.*;

public class CRUD_Transport {
    public static void read() throws SQLException {
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        System.out.println("Table Transport:");
        ResultSet resultSet=statement.executeQuery("SELECT * FROM transport_d;");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Transport");
            System.out.println(out);
        }
        connection.close();
    }

    public static void create(String transport) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO transport_d(Transport) VALUES ('" + transport + "')");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM transport_d ORDER BY id DESC LIMIT 1");
        System.out.print("Added: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Transport");
            System.out.println(out);
        }
        connection.close();
    }

    public static void update(int id, String transport) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE transport_d SET Transport='" + transport + "' WHERE id=" + id);
        ResultSet resultSet=statement.executeQuery("SELECT * FROM transport_d WHERE id=" + id);
        System.out.print("Changed: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Transport");
            System.out.println(out);
        }
        connection.close();
    }

    public static void delete(int id) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM transport_d WHERE id=" + id);
        read();
        connection.close();
    }
}
