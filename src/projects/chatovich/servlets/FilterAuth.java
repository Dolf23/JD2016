package projects.chatovich.servlets;

import projects.chatovich.servlets.DAO.UserDAO;
import projects.chatovich.servlets.JD03_02.DB_it_academy.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class FilterAuth implements Filter {


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        if (session == null) {
            resp.sendRedirect("/chatovich/login.jsp");
        }
        else {

            Object attr = session.getAttribute("auth");
            if (attr==(Boolean)true) {
                filterChain.doFilter(request,response);
                return;
            }
            else {
                resp.sendRedirect("/chatovich/login.jsp");
            }
            /*else{

                Cookie[] myCookies = req.getCookies();
                String cookieName = "login";
                String cookiePassword = "password";
                String login="";
                String password="";

                for (Cookie cookie : myCookies) {
                    if (cookieName.equals(cookie.getName())){
                        login = cookie.getValue();
                    }
                    if (cookiePassword.equals(cookie.getName())){
                        password = cookie.getValue();
                    }
                }

                UserDAO userDAO = new UserDAO();
                HashMap<Integer, User> users = new HashMap<>();
                try {
                    users = userDAO.getAll("where login = '"+login+"' and password = '"+password+"';");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (users.size()==0) {
                    //resp.sendRedirect("/chatovich/login.jsp");
                    req.getRequestDispatcher("/login.jsp").forward(req,resp);
                }
                else {
                    User user = new User();
                    for (Map.Entry<Integer, User> entry : users.entrySet()) {
                        user = entry.getValue();
                    }
                    *//*req.setAttribute("user", user);
                    req.setAttribute("ok", "hello");*//*
                    filterChain.doFilter(req,resp);
                    return;
                    //req.getRequestDispatcher(req.getRequestURI()).forward(req,resp);
                    //req.getRequestDispatcher("/search").forward(req,resp);
                }
            }*/
        }
        /*Cookie[] myCookies = req.getCookies();
        String cookieName = "login";
        String cookiePassword = "password";
        String login="";
        String password="";

        PrintWriter out = resp.getWriter();

        out.println(login+" - "+password);
        for (Cookie myCookie : myCookies) {
            out.println(myCookie.getName()+" - "+myCookie.getValue());
        }

        for (Cookie cookie : myCookies) {
            if (cookieName.equals(cookie.getName())){
                login = cookie.getValue();
            }
            if (cookiePassword.equals(cookie.getName())){
                password = cookie.getValue();
            }
        }

        UserDAO userDAO = new UserDAO();
        HashMap<Integer, User> users = new HashMap<>();
        try {
            users = userDAO.getAll("where login = '"+login+"' and password = '"+password+"';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (users.size()==0) {
            resp.sendRedirect("/chatovich/login.jsp");
        }
        else {
            filterChain.doFilter(request,response);
            return;
        }*/

    }

    public FilterAuth() {
        super();
    }


}
