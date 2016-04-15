package by.it.daylidovich.JD03_02.A_crud;

import by.it.daylidovich.JD03_01.C.CN;

import java.sql.*;

public class CRUD_Tours {
    public static void read() throws SQLException {
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        System.out.println("Table Tours:");
        ResultSet resultSet=statement.executeQuery("SELECT * FROM tours_d;");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getInt("FK_country") + " " + resultSet.getInt("FK_type_tour") + " " + resultSet.getInt("FK_transport") + " " + resultSet.getInt("FK_type_hotel") + " " + resultSet.getInt("FK_food_complex") + " " + resultSet.getInt("Cost") + " " + resultSet.getInt("Discount");
            System.out.println(out);
        }
        connection.close();
    }

    public static void create(int FK_country, int FK_typeTour, int FK_transport, int FK_typeHotel, int FK_foodComplex, int cost, int discount) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO tours_d(FK_country, FK_type_tour, FK_transport, FK_type_hotel, FK_food_complex, Cost, Discount) VALUES (" + FK_country + ", " + FK_typeTour + ", " + FK_transport + ", " + FK_typeHotel + ", " + FK_foodComplex + ", " + cost + ", " + discount  + ")");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM tours_d ORDER BY ID DESC LIMIT 1");
        System.out.print("Added row: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getInt("FK_country") + " " + resultSet.getInt("FK_type_tour") + " " + resultSet.getInt("FK_transport") + " " + resultSet.getInt("FK_type_hotel") + " " + resultSet.getInt("FK_food_complex") + " " + resultSet.getInt("Cost") + " " + resultSet.getInt("Discount");
            System.out.println(out);
        }
        connection.close();
    }

    public static void update(int id,int FK_country, int FK_typeTour, int FK_transport, int FK_typeHotel, int FK_foodComplex, int cost, int discount) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE tours_d SET FK_country=" + FK_country + ",  FK_type_tour=" + FK_typeTour + ",  FK_transport=" + FK_transport + ",  FK_type_hotel=" + FK_typeHotel + ",  FK_food_complex=" + FK_foodComplex + ",  Cost=" + cost + ", Discount="+ discount +" WHERE id=" + id);
        ResultSet resultSet=statement.executeQuery("SELECT * FROM tours_d WHERE id=" + id);
        System.out.print("changed: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getInt("FK_country") + " " + resultSet.getInt("FK_type_tour") + " " + resultSet.getInt("FK_transport") + " " + resultSet.getInt("FK_type_hotel") + " " + resultSet.getInt("FK_food_complex") + " " + resultSet.getInt("Cost") + " " + resultSet.getInt("Discount");
            System.out.println(out);
        }
        connection.close();
    }

    public static void delete(int id) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM tours_d WHERE id=" + id);
        read();
        connection.close();
    }
}
