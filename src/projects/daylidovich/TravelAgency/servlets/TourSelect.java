package projects.daylidovich.TravelAgency.servlets;

import projects.daylidovich.TravelAgency.servlets.DAO.ToursDAO;
import projects.daylidovich.TravelAgency.servlets.DTO.Tour;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TourSelect extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean is;
        PrintWriter printer = resp.getWriter();
        String sql;
        try{
            sql =String.format("WHERE FK_type_tour=%s, FK_country=%s, FK_transport=%s, FK_food_complex=%s, FK_type_hotel=%s",
                    req.getParameter("Type_tour"), req.getParameter("Country"), req.getParameter("Transport"), req.getParameter("Food_complex"), req.getParameter("Type_hotel"));
            ToursDAO toursDAO = new ToursDAO();
            List<Tour> list = toursDAO.getAll(sql);

            for (Tour tour: list)
                printer.println(tour.toString());
            printer.flush();
        }
        catch (Exception e){
            printer.println(e.toString());
        }
    }
}
