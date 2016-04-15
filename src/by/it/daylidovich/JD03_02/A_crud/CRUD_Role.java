package by.it.daylidovich.JD03_02.A_crud;

import by.it.daylidovich.JD03_01.C.CN;

import java.sql.*;

public class CRUD_Role {
    public static void read() throws SQLException {
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        System.out.println("Table Role:");
        ResultSet resultSet=statement.executeQuery("SELECT * FROM role_d;");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Role");
            System.out.println(out);
        }
        connection.close();
    }

    public static void create(String role) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO role_d(Role) VALUES ('" + role + "')");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM role_d ORDER BY id DESC LIMIT 1");
        System.out.print("Added: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Role");
            System.out.println(out);
        }
        connection.close();
    }

    public static void update(int id, String role) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE role_d SET Role='" + role + "' WHERE id=" + id);
        ResultSet resultSet=statement.executeQuery("SELECT * FROM role_d WHERE id=" + id);
        System.out.print("Changed: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Role");
            System.out.println(out);
        }
        connection.close();
    }

    public static void delete(int id) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM role_d WHERE id=" + id);
        read();
        connection.close();
    }
}
