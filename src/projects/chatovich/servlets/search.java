package projects.chatovich.servlets;

import projects.chatovich.servlets.DAO.CityDAO;
import projects.chatovich.servlets.DAO.FeedbackDAO;
import projects.chatovich.servlets.DAO.UserDAO;
import projects.chatovich.servlets.JD03_02.DB_it_academy.Feedback;
import projects.chatovich.servlets.JD03_02.DB_it_academy.User;
import projects.chatovich.servlets.Utils.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * servlet for searching users who live in the city, that was entered on client's side
 */
public class search extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        //PrintWriter out = resp.getWriter();

        String city = req.getParameter("city");
        req.setAttribute("city", city);

        HashMap <Integer, User> users = new HashMap<>();
        HashMap <Integer, User> allUsers = new HashMap<>();
        HashMap <Integer, Feedback> feedbacks = new HashMap<>();

        try{
            CityDAO cityDAO = new CityDAO();
            int id_city = cityDAO.getId(city);
            if (id_city!=0){
                UserDAO userDAO = new UserDAO();
                allUsers = userDAO.getAll("");
                users = userDAO.getAll("where id_city = '"+id_city+"';");
                FeedbackDAO feedbackDAO = new FeedbackDAO();
                feedbacks = feedbackDAO.getAll("");

            }
            else {
                req.setAttribute("anyUser", false);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/results.jsp");
                requestDispatcher.forward(req,resp);
                //resp.sendRedirect("/chatovich/results.jsp");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<User> list = new ArrayList<>();
        User user = new User();
        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            user = entry.getValue();
            //req.setAttribute("name",user.getName());
            Timestamp birthdate = user.getBirthdate();
            int age = Utils.getUserAge(birthdate);
            user.setAge(age);
            list.add(user);
        }

        List<User> listAllUsers = new ArrayList<>();
        User allUser = new User();
        for (Map.Entry<Integer, User> entry : allUsers.entrySet()) {
            allUser = entry.getValue();
            //req.setAttribute("name",user.getName());
            listAllUsers.add(allUser);
        }

        List<Feedback> listFeedbacks = new ArrayList<>();

        if (!feedbacks.isEmpty()) {
            Feedback feedback;
            for (Map.Entry<Integer, Feedback> entry : feedbacks.entrySet()) {
                feedback = entry.getValue();
                listFeedbacks.add(feedback);
                //out.println(feedback);

            }
            req.setAttribute("feedbacks", listFeedbacks);
            req.setAttribute("allUsers",listAllUsers);
        }
        req.setAttribute("anyUser", true);
        req.setAttribute("users", list);
        //req.setAttribute("feedbacks", listFeedbacks);
        req.setAttribute("user", user);
        req.setAttribute("usersQuantity", list.size());


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/results.jsp");
        requestDispatcher.forward(req,resp);

        //resp.sendRedirect("/chatovich/results.jsp");




    }
}
