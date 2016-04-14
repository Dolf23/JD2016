package projects.daylidovich.TravelAgency.servlets;

import projects.daylidovich.TravelAgency.servlets.DAO.ActionDAO;
import projects.daylidovich.TravelAgency.servlets.DAO.TypeActionDAO;
import projects.daylidovich.TravelAgency.servlets.DTO.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Reserve extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean is;
        Action action = new Action();
        PrintWriter printer = resp.getWriter();
        try{
            action.setFk_action(TypeActionDAO.getID("Reserve"));
            action.setFk_tour(1);
            action.setFk_user(1);

            ActionDAO actionDAO = new ActionDAO();
            is = actionDAO.create(action);
            if (!is)
                new Exception("Action not added.");
            printer.println(action.toString());
            printer.flush();

        } catch (Exception e) {
            printer.println(e.toString());
        }
    }
}
