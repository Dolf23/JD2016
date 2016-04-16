package projects.baranova.servlets.DAO;


import java.sql.*;

public class RoleDAO {
    //этот класс получает готовые данные из справочника
    public Integer getID(String strRole) throws SQLException {
        //Read
        Integer res = null;
        String sql = "SELECT idRole FROM Role WHERE Rolecol=" + strRole + ";";
        try (Connection connection = Cnn.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getInt("idRole");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getRole(Integer id) throws SQLException {
        //Read
        String res = null;
        String sql = "SELECT * FROM Role WHERE idRole=" + id + ";";
        try (Connection connection = Cnn.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getString("Rolecol");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}

