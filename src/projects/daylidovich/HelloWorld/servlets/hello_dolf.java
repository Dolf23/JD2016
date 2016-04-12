package projects.daylidovich.HelloWorld.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class hello_dolf extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            PrintWriter out = resp.getWriter();
            out.println("Hello world");
            out.flush();
            try {
                getConnection();
            } catch (Exception e) {
                out.println(e+" Bad");
                e.printStackTrace();
            }
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Post intercepted.");
        out.flush();
        try{
            getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static final String USER_DB = "root";
    public static final String PASSWORD_DB = "";

    public static Connection getConnection() throws SQLException {
        final String URL = "jdbc:mysql://localhost:2016/it_academy" + "?useUnicode=true&characterEncoding=UTF-8";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
        return DriverManager.getConnection(URL, USER_DB, PASSWORD_DB);
    }
}

