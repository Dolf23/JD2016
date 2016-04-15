package by.it.daylidovich.JD03_02.A_crud;

import by.it.daylidovich.JD03_01.C.CN;

import java.sql.*;

public class CRUD_Users {
    public static void read() throws SQLException {
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        System.out.println("Table User:");
        ResultSet resultSet=statement.executeQuery("SELECT * FROM users_d;");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Name") + " " + resultSet.getString("Surname") + " " + resultSet.getString("Email") + " " + resultSet.getString("Login") + " " + resultSet.getString("Password") + " " + resultSet.getInt("FK_Role");
            System.out.println(out);
        }
        connection.close();
    }

    public static void create(String Name , String Surname, String Email, String Login, String Password, int FK_Role) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO users_d(Name, Surname, Email, Login, Password, FK_Role) VALUES ('" + Name + "', '" + Surname + "', '" + Email + "', '" + Login + "', '" + Password + "', " + FK_Role + ")");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users_d ORDER BY ID DESC LIMIT 1");
        System.out.print("Added row: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Name") + " " + resultSet.getString("Surname") + " " + resultSet.getString("Email") + " " + resultSet.getString("Login") + " " + resultSet.getString("Password") + " " + resultSet.getInt("FK_Role");
            System.out.println(out);
        }
        connection.close();
    }

    public static void update(int id, String Name , String Surname, String Email, String Login, String Password, int FK_Role) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE users_d SET Name='" + Name + "',  Surname='" + Surname + "',  Email='" + Email + "',  Login='" + Login + "',  Password='" + Password + "',  FK_Role='" + FK_Role + "' WHERE id=" + id);
        ResultSet resultSet=statement.executeQuery("SELECT * FROM users_d WHERE id=" + id);
        System.out.print("changed: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getString("Name") + " " + resultSet.getString("Surname") + " " + resultSet.getString("Email") + " " + resultSet.getString("Login") + " " + resultSet.getString("Password") + " " + resultSet.getInt("FK_Role");
            System.out.println(out);
        }
        connection.close();
    }

    public static void delete(int id) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM users_d WHERE id=" + id);
        read();
        connection.close();
    }
}
