package projects.baranova.servlets.DAO;

import java.sql.*;

public class BedSizeDAO {

    //этот класс получает готовые данные из справочника
    Integer getID(String strBedSize) throws SQLException {
        //Read
        Integer res = null;
        String sql = "SELECT idBedSize FROM BedSize WHERE BedSizecol=" + strBedSize + ";";
        try (Connection connection = Cnn.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getInt("idBedSize");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    String getBedSize(Integer id) throws SQLException {
        //Read
        String res = null;
        String sql = "SELECT * FROM BedSize WHERE idBedSize=" + id + ";";
        try (Connection connection =  Cnn.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getString("BedSizecol");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}

