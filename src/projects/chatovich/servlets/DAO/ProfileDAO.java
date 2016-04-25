package projects.chatovich.servlets.DAO;


import projects.chatovich.servlets.JD03_02.DB_it_academy.Profile;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * profile DAO
 */
public class ProfileDAO extends DAO implements InterfaceDAO<Profile> {


    @Override
    public boolean create(Profile profile) throws SQLException {
        String sql = String.format("insert into profiles (id_user, id_city, description) " +
                        "values ('%d','%d','%s' );", profile.getId_user(), profile.getId_city(),
                profile.getDescription());

        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean update(Profile profile) throws SQLException {
        String sql = String.format(
                "UPDATE profiles SET id_city = '%d', description = '%s' " +
                        "WHERE id_user = %d", profile.getId_city(), profile.getDescription(),
                profile.getId_city());

        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Profile profile) throws SQLException {
        String sql = String.format(
                "DELETE FROM profiles WHERE id_user = %d;", profile.getId_user());

        return (0 < executeUpdate(sql));
    }

    @Override
    public Profile read(int id) throws SQLException {
        HashMap<Integer, Profile> profiles = getAll("where id_user = "+id);
        if (profiles.size()>0)
            return profiles.get(id);
        else return null;
    }

    @Override
    public HashMap<Integer, Profile> getAll(String where) throws SQLException {
        HashMap <Integer, Profile> profiles = new HashMap<>();
        String sql = "SELECT * FROM profiles " + where + " ;";
        /*try (
                Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
                Statement statement = connection.createStatement()
        ) {*/
        Statement statement = DAO.getStatement();
        ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Profile profile = new Profile();
                profile.setId_user(rs.getInt("id_user"));
                profile.setId_city(rs.getInt("id_city"));
                profile.setDescription(rs.getString("description"));
                profiles.put(rs.getInt("id_user"),profile);

            }
        /*} catch (SQLException e) {
            e.printStackTrace();
        }*/
        return profiles;
    }

    @Override
    public void showTable() throws SQLException {
        HashMap<Integer, Profile> profiles = getAll("");
        System.out.println("PROFILES");
        for (Map.Entry<Integer, Profile> entry : profiles.entrySet()) {
            String s = "Profile "+entry.getKey() + ": "+entry.getValue();
            System.out.println(s);
        }
    }
}
