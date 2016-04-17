package projects.chatovich.servlets;

import projects.chatovich.servlets.DAO.CityDAO;
import projects.chatovich.servlets.DAO.FeedbackDAO;
import projects.chatovich.servlets.DAO.UserDAO;
import projects.chatovich.servlets.JD03_02.DB_it_academy.Feedback;
import projects.chatovich.servlets.JD03_02.DB_it_academy.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * userProfile
 */
public class userProfile extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        /*PrintWriter out = resp.getWriter();
        int id_user = Integer.parseInt(req.getParameter("id_user"));
        String login = req.getParameter("login_user");
        out.println(id_user);*/

        int id_user = Integer.parseInt(req.getParameter("id_user"));
        User user = new User();
        HashMap<Integer, User> users = new HashMap<>();
        HashMap<Integer, User> allUsers = new HashMap<>();
        HashMap<Integer, Feedback> feedbacks = new HashMap<>();
        List<Feedback> listFeedbacks = new ArrayList<>();
        List<User> listUsers = new ArrayList<>();
        List<User> listAllUsers = new ArrayList<>();
        String city="";
        try{
            UserDAO userDAO = new UserDAO();
            users = userDAO.getAll("where id = '" +id_user+"';");
            allUsers = userDAO.getAll("");
            FeedbackDAO feedbackDAO = new FeedbackDAO();
            feedbacks = feedbackDAO.getAll("where feedback_to = '"+id_user+"';");
            for (Map.Entry<Integer, Feedback> entry : feedbacks.entrySet()) {
                listFeedbacks.add(entry.getValue());
            }
            for (Map.Entry<Integer, User> entry : allUsers.entrySet()) {
                listAllUsers.add(entry.getValue());
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (users.size()==1){
            for (Map.Entry<Integer, User> entry : users.entrySet()) {
                listUsers.add(entry.getValue());
                try{
                    CityDAO cityDAO = new CityDAO();
                    city = cityDAO.getCity(entry.getValue().getId());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        req.setAttribute("users", listUsers);
        req.setAttribute("feedbacks", listFeedbacks);
        req.setAttribute("allUsers", listAllUsers);
        req.setAttribute("city", city);

        req.getRequestDispatcher("/profil.jsp").forward(req,resp);


    }
}
