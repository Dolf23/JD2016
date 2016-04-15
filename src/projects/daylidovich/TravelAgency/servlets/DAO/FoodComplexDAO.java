package projects.daylidovich.TravelAgency.servlets.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodComplexDAO {
    public static Integer getID(String food) throws SQLException {
        Integer out = null;
        String sql = String.format("SELECT ID FROM food_complex_d WHERE Food_complex='%s';", food);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getInt("id");
        return out;
    }

    public static String getFoodComplex(Integer id) throws SQLException {
        String out = null;
        String sql = String.format("SELECT * FROM food_complex_d WHERE ID='%d';", id);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getString("Food_complex");
        return out;
    }
}
