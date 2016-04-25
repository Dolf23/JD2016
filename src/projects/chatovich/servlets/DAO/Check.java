package projects.chatovich.servlets.DAO;


import java.sql.SQLException;


/**
 * Временный класс для проверок
 */
public class Check {

    public static void main(String[] args) throws SQLException {

        UserDAO userDAO = new UserDAO();
        CityDAO cityDAO = new CityDAO();
        RoleDAO roleDAO = new RoleDAO();
        System.out.println(roleDAO.getId("user"));



       // userDAO.showTable();





        //System.out.println(roleDAO.getRole(1));
        //System.out.println(roleDAO.getId("user"));
        //profileDAO.showTable();
        //System.out.println(cityDAO.getId("Minsk"));

        //добавляем профиль и выводим его
        /*int userId = userDAO.getUserId("where surname = 'Lauryn' and name = 'Kiryl'");
        if (userId!=0){
            Profile profile = new Profile(userId,1,"profile");
            System.out.println(userId);
            if (profileDAO.create(profile)) System.out.println("Профиль добавлен");
            profileDAO.read(userId);
        }
        else System.out.println("Не существует такого пользователя");*/



        /*User user = new User("Anna","Drake","drake","yultos", new Timestamp(630720000000l),1,"drake@gmail.com");
        if (userDAO.create(user)) System.out.println("Пользователь добавлен.");
        System.out.println(user);

        //обновляем пользователя и выводим
        user = userDAO.getAll("where id = 5").get(5);
        user.setSurname("Marshall");
        if (userDAO.update(user)) System.out.println("Пользователь обновлен.");
        System.out.println(userDAO.read(5));

        //удаление ользователя и вывод оставшихся
        if (userDAO.delete(user)) System.out.println("Пользователь удалён");
        userDAO.showTable();*/
    }
}
