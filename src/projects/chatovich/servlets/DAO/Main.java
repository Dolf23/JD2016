package projects.chatovich.servlets.DAO;


import projects.chatovich.servlets.JD03_02.DB_it_academy.User;

import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws SQLException {

        DAO.getDAO();

        UserDAO userDAO = new UserDAO();
        userDAO.showTable();

        //добавляем пользователя и выводим его
        User user = new User("Anna","Drake","drake","yultos", Timestamp.valueOf("1980-05-15 00:00:00"),1,"drake@gmail.com",2,"");
        if (userDAO.create(user)) System.out.println("Пользователь добавлен.");
        System.out.println(user);

        //обновляем пользователя и выводим
        User user1 = userDAO.getAll("where id = 1").get(1);
        user1.setSurname("Marshall");
        if (userDAO.update(user1)) System.out.println("Пользователь обновлен.");
        System.out.println(userDAO.read(1));

        //удаление ользователя и вывод оставшихся
        if (userDAO.delete(user1)) System.out.println("Пользователь удалён");
        userDAO.showTable();

        DAO.closeDAO();

    }
}
