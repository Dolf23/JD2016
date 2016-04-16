package projects.baranova.servlets;

import projects.baranova.servlets.DAO.Users;
import projects.baranova.servlets.DAO.UsersDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class login extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException{

        response.setContentType("text/html");

        request.getRequestDispatcher("signin.jsp").include(request,response);
        String login=request.getParameter("Login");
        String password=request.getParameter("Password");

        if (true) {
            Cookie userCookie = new Cookie("Login", login);
            userCookie.setMaxAge(60 * 60);
            response.addCookie(userCookie);
            response.sendRedirect("loginsuccess.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/crunchify-login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Please make sure you enter right UserID/Pass.</font>\n");
            rd.include(request, response);
            out.close();
        }

    }


}
