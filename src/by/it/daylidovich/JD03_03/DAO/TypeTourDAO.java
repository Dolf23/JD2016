package by.it.daylidovich.JD03_03.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeTourDAO {
    public static Integer getID(String typeTour) throws SQLException {
        Integer out = null;
        String sql = String.format("SELECT ID FROM type_tour_d WHERE Type_tour='%s';", typeTour);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getInt("id");
        return out;
    }

    public static String getTypeTour(Integer id) throws SQLException {
        String out = null;
        String sql = String.format("SELECT * FROM type_tour_d WHERE ID='%d';", id);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getString("Type_tour");
        return out;
    }
}
