package by.it.daylidovich.JD03_02.A_crud;

import by.it.daylidovich.JD03_01.C.CN;

import java.sql.*;

public class CRUD_FoodComplex {
    public static void read() throws SQLException {
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        System.out.println("Table Food complex:");
        ResultSet resultSet=statement.executeQuery("SELECT * FROM food_complex_d;");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Food_complex");
            System.out.println(out);
        }
        connection.close();
    }

    public static void create(String complex) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO food_complex_d(Food_complex) VALUES ('" + complex + "')");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM food_complex_d ORDER BY id DESC LIMIT 1");
        System.out.print("Added: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Food_complex");
            System.out.println(out);
        }
        connection.close();
    }

    public static void update(int id, String complex) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE food_complex_d SET Food_complex='" + complex + "' WHERE id=" + id);
        ResultSet resultSet=statement.executeQuery("SELECT * FROM food_complex_d WHERE id=" + id);
        System.out.print("Changed: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Food_complex");
            System.out.println(out);
        }
        connection.close();
    }

    public static void delete(int id) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM food_complex_d WHERE id=" + id);
        read();
        connection.close();
    }
}
