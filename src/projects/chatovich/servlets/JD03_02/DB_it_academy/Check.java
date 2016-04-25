package projects.chatovich.servlets.JD03_02.DB_it_academy;

import projects.chatovich.servlets.DAO.UserDAO;

import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created
 */
public class Check {

    public static void main(String[] args) throws SQLException {
        User user=new User();
        try{

            user.setName("name");
            user.setSurname("surname");
            user.setEmail("email");
            user.setPassword("password");
            user.setRole(1);
            user.setCity(2);
            user.setBirthdate(new Timestamp(45654655488l));
            user.setDescribtion("describtion");
            user.setLogin("login");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(user);

        UserDAO userDAO = new UserDAO();
        userDAO.create(user);
    }
}
