package projects.chatovich.servlets.DAO;




import projects.chatovich.servlets.JD03_02.DB_it_academy.City;
import projects.chatovich.servlets.JD03_02.DB_it_academy.User;

import java.sql.*;
import java.util.HashMap;


/**
 * City DAO
 */
public class CityDAO extends DAO {

    public  Integer getId (String city) throws SQLException {

        Integer res = 0;
        String sql = "SELECT * FROM cities WHERE city='" + city + "';";
        /*try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {*/
        Statement statement = DAO.getStatement();
        ResultSet rs = statement.executeQuery(sql);
            if (rs.next()){
                res = rs.getInt("id_city");
            }
        /*} catch (Exception e) {
            e.printStackTrace();
        }*/
        return res;
    }

    public  String getCity (Integer id) throws SQLException{

        String res = null;
        String sql = "SELECT * FROM cities WHERE id_city=" + id + ";";
        /*try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {*/
        Statement statement = DAO.getStatement();
        ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getString("city");
        /*} catch (Exception e) {
            e.printStackTrace();
        }*/
        return res;
    }

    public boolean create(String city) throws SQLException {
        String sql = String.format("insert into cities (city) values ('%s' );", city);

        return (0 < executeUpdate(sql));
    }

    public boolean isInDB(String city) throws SQLException {

        String sql = "SELECT * FROM cities where city ='"+city+"';";
        /*try (
                Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
                Statement statement = connection.createStatement()
        ) {*/
        Statement statement = DAO.getStatement();
        ResultSet rs = statement.executeQuery(sql);
        String s = null;
        while (rs.next()) {
            s = rs.getString("city");
        }

        /*} catch (SQLException e) {
            e.printStackTrace();
        }*/
        return (s!=null);
    }


}
