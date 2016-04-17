package projects.chatovich.servlets;


import projects.chatovich.servlets.DAO.UserDAO;
import projects.chatovich.servlets.JD03_02.DB_it_academy.User;
import projects.chatovich.servlets.Utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class login extends HttpServlet {

   /* public static void main(String[] args) {

        HashMap<Integer, User> users = null;
        UserDAO userDAO = new UserDAO();
        try {
            System.out.println("inside");
            users = userDAO.getAll("where login = 'chatovich' and password = 'yultos';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            System.out.println(entry);
        }
    }*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        HashMap<Integer, User> users = new HashMap<>();
        UserDAO userDAO = new UserDAO();

        try {

            users = userDAO.getAll("where login = '"+login+"' and password = '"+password+"';");
            for (Map.Entry<Integer, User> entry : users.entrySet()) {
                out.println(entry.getValue());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //out.println(users.get(0));

        if (users.size()==1) {
            User user = new User();
            for (Map.Entry<Integer, User> entry : users.entrySet()) {
                user = entry.getValue();
                Timestamp birthdate = user.getBirthdate();
                int age = Utils.getUserAge(birthdate);
                user.setAge(age);
            }
            req.setAttribute("userIn", true);
            HttpSession session = req.getSession();
            session.setAttribute("auth",true);

            session.setAttribute("user",user);
            /*Cookie logCookie = new Cookie("login",login);
            logCookie.setMaxAge(60*60*24);
            resp.addCookie(logCookie);

            Cookie pasCookie = new Cookie("password",password);
            pasCookie.setMaxAge(60*60*24);
            resp.addCookie(pasCookie);*/
            session.setAttribute("auth",(Boolean)true);
            session.setAttribute("login", login);
            //resp.sendRedirect("/chatovich/index.jsp");

            req.setAttribute("user",user);
            req.getRequestDispatcher("/index.jsp").forward(req,resp);

        } else {
            resp.sendRedirect("/chatovich/loginTryAgain.jsp");

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
