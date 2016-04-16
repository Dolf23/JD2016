package projects.chatovich.servlets;

import projects.chatovich.servlets.DAO.CityDAO;
import projects.chatovich.servlets.DAO.UserDAO;
import projects.chatovich.servlets.JD03_02.DB_it_academy.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * servlet for registration
 */
public class reg extends HttpServlet{

    /*public static void main(String[] args) {

        String city = "z";
        try{
            CityDAO cityDAO = new CityDAO();
            //если такого города в базе ещё нет
            boolean b = cityDAO.isInDB(city);
            System.out.println(b);
            if (!b)
                cityDAO.create(city);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    /*public static void main(String[] args) throws SQLException {
        User user=new User();
        try{

            user.setName("Name");
            user.setSurname("surname");
            user.setEmail("email");
            user.setPassword("password");
            user.setRole(1);
            user.setCity(2);
            user.setBirthdate(new Timestamp(45654655488l));
            user.setDescribtion("describtion");
            user.setLogin("login");

            Feedback feedback = new Feedback();
            feedback.setFeedback_from(1);
            feedback.setFeedback_to(2);
            feedback.setFeedback_text("");
            System.out.println(feedback);
            FeedbackDAO feedbackDAO = new FeedbackDAO();
            feedbackDAO.create(feedback);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(user);

        UserDAO userDAO = new UserDAO();
        userDAO.create(user);
    }*/



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("loginExists",false);
        req.setAttribute("l",false);
        String message = "";

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String city = req.getParameter("city");
        String login = req.getParameter("login");
        String password = req.getParameter("password");


        User user = (User)req.getSession().getAttribute("user");

        try{
            CityDAO cityDAO = new CityDAO();
            UserDAO userDAO = new UserDAO();
            if (user==null) {
                user = new User();
                //если такого города в базе ещё нет
                boolean b = cityDAO.isInDB(city);
                if (!b)
                    cityDAO.create(city);

                //проверяем есть ли в базе пользователь с таким логином и паролем
                HashMap<Integer, User> users = new HashMap<>();
                users = userDAO.getAll("where login = '"+login+"' and password = '"+password+"';");
                if (!users.isEmpty()){
                    req.setAttribute("loginExists",true);
                    req.getRequestDispatcher("/register.jsp").forward(req,resp);
                }
                user.setName(name);
                user.setSurname(surname);
                user.setEmail(req.getParameter("email"));
                user.setPassword(password);
                user.setCity(cityDAO.getId(city));

                //конвертируем строку, полученную от пользователя, в timestamp
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date parsedDate = dateFormat.parse(req.getParameter("birthdate"));
                Timestamp timestamp = new Timestamp(parsedDate.getTime());

                user.setBirthdate(timestamp);
                user.setDescribtion(req.getParameter("describtion"));
                user.setLogin(login);

                userDAO.create(user);
                message="Congratulations! You're now registered at SearchHost! To start please log in.";
            }

            else{
                int id = Integer.parseInt(req.getParameter("id"));
                /*PrintWriter out = resp.getWriter();
                out.println(id);
                out.println(user.getId());*/

                if (id < 0) {

                    //user.setId(-1 * user.getId());
                    String deletedName = user.getName();
                    String deletedSurname = user.getSurname();
                    userDAO.delete(user);
                    message = deletedName + " " + deletedSurname + "'s profile was deleted from SearchHost";
                    req.getSession().invalidate();
                    req.setAttribute("userIn", false);
                } else {
                    userDAO.update(user);
                    message = user.getName() + " " + user.getSurname() + "'s profile was updated.";

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        req.setAttribute("message", message);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("get");
    }*/
}
