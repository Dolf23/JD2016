package projects.chatovich.servlets.DAO;


import java.sql.*;

/**
 * Role DAO
 */
public class RoleDAO extends DAO {

    public  Integer getId (String role) throws SQLException{

        Integer res = null;
        String sql = "SELECT * FROM role WHERE role_type='" + role + "';";
        /*try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {*/
            Statement statement = getStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()){
                res = rs.getInt("id_role");
            }
        /*} catch (Exception e) {
            e.printStackTrace();
        }*/
        return res;
    }

    public  String getRole (Integer id) throws SQLException{

        String res = null;
        String sql = "SELECT * FROM role WHERE id_role=" + id + ";";
        /*try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {*/

        Statement statement = DAO.getStatement();
        ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) res = rs.getString("role_type");
        /*} catch (Exception e) {
            e.printStackTrace();
        }*/
        return res;
    }
}
