package projects.daylidovich.TravelAgency.servlets.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransportDAO {
    public static Integer getID(String transport) throws SQLException {
        Integer out = null;
        String sql = String.format("SELECT ID FROM transport_d WHERE Transport='%s';", transport);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getInt("id");
        return out;
    }

    public static String getTransport(Integer id) throws SQLException {
        String out = null;
        String sql = String.format("SELECT * FROM transport_d WHERE ID='%d';", id);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getString("Transport");
        return out;
    }
}
