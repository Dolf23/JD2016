package projects.daylidovich.TravelAgency.servlets.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountreisDAO {
    public static Integer getID(String country) throws SQLException {
        Integer out = null;
        String sql = String.format("SELECT ID FROM countries_d WHERE Country='%s';", country);
        ResultSet resultSet = by.it.daylidovich.JD03_03.DAO.DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getInt("id");

        return out;
    }

    public static String getCountry(Integer id) throws SQLException {
        String out = null;
        String sql = String.format("SELECT * FROM countries_d WHERE ID='%d';", id);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getString("Country");
        return out;
    }
}
