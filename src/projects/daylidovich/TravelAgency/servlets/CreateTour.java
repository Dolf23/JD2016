package projects.daylidovich.TravelAgency.servlets;

import projects.daylidovich.TravelAgency.servlets.DAO.*;
import projects.daylidovich.TravelAgency.servlets.DTO.Tour;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateTour extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printer = resp.getWriter();
        boolean is;
        Tour tour = new Tour();
        try {
            tour.setFk_type_tour(Integer.parseInt(req.getParameter("Type_tour")));
            tour.setFk_country(CountriesDAO.getID(req.getParameter("Country")));
            tour.setFk_transport(TransportDAO.getID(req.getParameter("Transport")));
            tour.setFk_type_hotel(TypeHotelDAO.getID(req.getParameter("Type_hotel")));
            tour.setFk_food_complex(FoodComplexDAO.getID(req.getParameter("Food_complex")));
            tour.setCost(Integer.parseInt(req.getParameter("Cost")));
            tour.setDiscount(0);

            ToursDAO toursDAO = new ToursDAO();
            is = toursDAO.create(tour);
            if (!is)
                new Exception("Error create tour.");
        }
        catch (Exception e){
            printer.println(e.toString());
        }
        printer.println(tour.toString());
        printer.flush();
    }
}
