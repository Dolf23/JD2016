package projects.baranova.servlets.DAO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends DAO implements InterfaceDAO<Users> {

    @Override
    public List<Users> getAll(String Where){
        List<Users> userslist=new ArrayList<>();
        String sql="SELECT * FROM Users "+Where+" ;";
        try (Connection connection = Cnn.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()){
                Users users = new Users();
                users.setIdUsers(rs.getInt("idUsers"));
                users.setLogin(rs.getString("Login"));
                users.setName(rs.getString("Name"));
                users.setSurname(rs.getString("Surname"));
                users.setMail(rs.getString("Mail"));
                users.setPhonenumber(rs.getString("Phonenumber"));
                users.setPassword(rs.getString("Password"));
                users.setFKRole(rs.getInt("FKRole"));
                userslist.add(users);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    return userslist;
    }

    @Override
    public Users read(int id) {
        List<Users> users = getAll("WHERE idUsers=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Users users){
        String sql = String.format(
                "insert INTO Users(Login,Password,Name,Surname,Phonenumber,Mail,FKRole)" +
                        " values('%s','%s','%s', '%s', '%s', '%s', %d);",
                users.getLogin(), users.getPassword(), users.getName(),users.getSurname(), users.getPhonenumber(), users.getMail(), users.getFKRole()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean update(Users users){
        String sql=String.format(
        "UPDATE Users SET Login = '%s', Password = '%s',Name= '%s', Surname= '%s', Phonenumber= '%s',Mail = '%s', FKRole = '%d' WHERE Users.idUsers = %d",
                users.getLogin(), users.getPassword(), users.getName(),users.getSurname(), users.getPhonenumber(), users.getMail(), users.getFKRole(), users.getIdUsers()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Users users) {
        String sql = String.format(
                "DELETE FROM Users WHERE Users.idUsers = %d;", users.getIdUsers()
        );
        return (0 < executeUpdate(sql));
    }
}
