package projects.chatovich.servlets;

import projects.chatovich.servlets.DAO.FeedbackDAO;
import projects.chatovich.servlets.JD03_02.DB_it_academy.Feedback;
import projects.chatovich.servlets.JD03_02.DB_it_academy.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * adds a feedback to the base
 */
public class addFeedback extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String text = req.getParameter("message");
        User userFBauthor = (User)req.getSession().getAttribute("user");
        int idFBreceiver = Integer.parseInt(req.getParameter("idFBreceiver"));
        Feedback feedback = new Feedback();
        feedback.setFeedback_text(text);
        feedback.setFeedback_to(idFBreceiver);
        feedback.setFeedback_from(userFBauthor.getId());

        try{
            FeedbackDAO feedbackDAO = new FeedbackDAO();
            feedbackDAO.create(feedback);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        String message="Thanks for your feedback";
        req.setAttribute("message", message);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
