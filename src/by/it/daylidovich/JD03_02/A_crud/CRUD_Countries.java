package by.it.daylidovich.JD03_02.A_crud;

import by.it.daylidovich.JD03_01.C.CN;

import java.sql.*;

public class CRUD_Countries {

        public static void read() throws SQLException {
            Connection connection  = CN.getConnection();
            Statement statement = connection.createStatement();
            System.out.println("Table Countries:");
            ResultSet resultSet=statement.executeQuery("SELECT * FROM countries_d;");
            while (resultSet.next()){
                String out=resultSet.getInt("id")+" "+resultSet.getString("Country");
                System.out.println(out);
            }
            connection.close();
        }

        public static void create(String country) throws SQLException{
            Connection connection  = CN.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO countries_d(Country) VALUES ('" + country + "')");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM countries_d ORDER BY id DESC LIMIT 1");
            System.out.print("Added: ");
            while (resultSet.next()){
                String out=resultSet.getInt("id")+" "+resultSet.getString("Country");
                System.out.println(out);
            }
            connection.close();
        }

        public static void update(int id, String country) throws SQLException{
            Connection connection  = CN.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE countries_d SET Country='" + country + "' WHERE id=" + id);
            ResultSet resultSet=statement.executeQuery("SELECT * FROM countries_d WHERE id=" + id);
            System.out.print("Changed: ");
            while (resultSet.next()){
                String out=resultSet.getInt("id")+" "+resultSet.getString("Country");
                System.out.println(out);
            }
            connection.close();
        }

        public static void delete(int id) throws SQLException{
            Connection connection  = CN.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM countries_d WHERE id=" + id);
            read();
            connection.close();
        }
}
