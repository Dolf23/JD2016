package projects.daylidovich.TravelAgency.servlets;

import projects.daylidovich.TravelAgency.servlets.DAO.RoleDAO;
import projects.daylidovich.TravelAgency.servlets.DAO.UsersDAO;
import projects.daylidovich.TravelAgency.servlets.DTO.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Registry extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean is;
        PrintWriter printer = resp.getWriter();
        User user = new User();
        try{
            user.setName(req.getParameter("Name"));
            user.setSurname(req.getParameter("Surname"));
            user.setEmail(req.getParameter("Email"));
            user.setLogin(req.getParameter("Login"));
            user.setPassword(req.getParameter("Password"));
            user.setFk_Role(RoleDAO.getID(req.getParameter("Role")));

            UsersDAO usersDAO = new UsersDAO();
            is = usersDAO.create(user);
            if (!is)
                new Exception("User not created");
            printer.println(user.toString());
            printer.flush();
        } catch (Exception e) {
            printer.println(e.toString());
        }

    }
}
