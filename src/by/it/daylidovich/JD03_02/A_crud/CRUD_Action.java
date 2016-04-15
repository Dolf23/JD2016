package by.it.daylidovich.JD03_02.A_crud;

import by.it.daylidovich.JD03_01.C.CN;

import java.sql.*;

public class CRUD_Action {
    public static void read() throws SQLException {
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        System.out.println("Table Action:");
        ResultSet resultSet=statement.executeQuery("SELECT * FROM action_d;");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getInt("FK_action") + " " + resultSet.getInt("FK_user") + " " + resultSet.getInt("FK_tour");
            System.out.println(out);
        }
        connection.close();
    }

    public static void create(int FK_action, int FK_user, int FK_tour) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO action_d(FK_action, FK_user, FK_tour) VALUES (" + FK_action + ", " + FK_user + ", " + FK_tour   + ")");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM action_d ORDER BY ID DESC LIMIT 1");
        System.out.print("Added row: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getInt("FK_action") + " " + resultSet.getInt("FK_user") + " " + resultSet.getInt("FK_tour");
            System.out.println(out);
        }
        connection.close();
    }

    public static void update(int id,int FK_action, int FK_user, int FK_tour) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE action_d SET FK_action=" + FK_action + ",  FK_user=" + FK_user + ",  FK_tour=" + FK_tour + " WHERE id=" + id);
        ResultSet resultSet=statement.executeQuery("SELECT * FROM action_d WHERE id=" + id);
        System.out.print("changed: ");
        while (resultSet.next()){
            String out=resultSet.getInt("id")+" "+resultSet.getInt("FK_action") + " " + resultSet.getInt("FK_user") + " " + resultSet.getInt("FK_tour");
            System.out.println(out);
        }
        connection.close();
    }

    public static void delete(int id) throws SQLException{
        Connection connection  = CN.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM action_d WHERE id=" + id);
        read();
        connection.close();
    }
}
