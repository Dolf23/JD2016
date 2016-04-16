package projects.chatovich.servlets;

import projects.chatovich.servlets.JD03_02.DB_it_academy.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Crea
 */
public class delete extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        User user = (User)req.getSession().getAttribute("user");
        out.print(user);
        out.println(req.getParameter("id"));

        user.setId(Integer.parseInt(req.getParameter("id")));
        out.println(user.getId());
    }
}
