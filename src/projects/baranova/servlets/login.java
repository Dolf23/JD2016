package projects.baranova.servlets;

import projects.baranova.servlets.DAO.Orders;
import projects.baranova.servlets.DAO.OrdersDAO;
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
import java.util.List;

public class login extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException{

        response.setContentType("text/html");
        request.getRequestDispatcher("signin.jsp").include(request,response);

        String login=request.getParameter("Login");
        String password=request.getParameter("Password");
        List<Users> loginuser=new UsersDAO().getAll("WHERE Login='"+login+"'");
        String pass="";
        String log="";
        for (Users users:loginuser){
            pass=users.getPassword();
            log=users.getLogin();
        }

        if (login.equals(log)&&password.equals(pass)) {
            Cookie userCookie = new Cookie("Login", login);
            userCookie.setMaxAge(60 * 60);
            response.addCookie(userCookie);
            request.setAttribute("login", login);
            request.getRequestDispatcher("loginsuccess.jsp").forward(request,response);
            response.sendRedirect("loginsuccess.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/signin.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Please make sure you enter right Login/Password.</font>\n");
            rd.include(request, response);
            out.close();
        }

    }


}
