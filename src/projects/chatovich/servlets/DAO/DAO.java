package projects.chatovich.servlets.DAO;

import projects.chatovich.servlets.JD03_02.DB_it_academy.CN;
import projects.chatovich.servlets.JD03_02.DB_it_academy.Logger;
import projects.chatovich.servlets.Xampp;


import java.sql.*;
import java.util.HashMap;

/**
 * Dao
 */
public class DAO<T> {

    private static Connection connection;
    private static Statement statement;
    private static DAO dao;

    public DAO() {
        try {
            connection = Xampp.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getInstance().writeToLog(e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static Statement getStatement() {
        return statement;
    }

    static DAO getDAO() {
        if (dao == null) {
            dao = new DAO();
        }
        return dao;
    }

    static void closeDAO() {
        dao = null;
    }

    static int executeUpdate(String sql) throws SQLException {

        int result = -1;
        /*try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {*/
            Statement statement = getStatement();
            result = statement.executeUpdate(sql);
        /*} catch (Exception e) {
            e.printStackTrace();
        }*/
        return result;
    }




}
