package projects.baranova.servlets;

import projects.baranova.servlets.DAO.RoleDAO;
import projects.baranova.servlets.DAO.Users;
import projects.baranova.servlets.DAO.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


public class userform extends HttpServlet {

    public static void main(String[] args) throws SQLException {

        System.out.print(new RoleDAO().getRole(1));
        Users users = new Users();
        users.setIdUsers(Integer.parseInt("0"));
        users.setLogin("us");
        users.setPassword("pass");
        users.setName("Leo");
        users.setSurname("Di Caprio");
        users.setMail("em");
        users.setPhonenumber("+375233747634");
        users.setFKRole(1);
        System.out.print(users);
        UsersDAO userDAO = new UsersDAO();
        userDAO.create(users);
    }


    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //тут нужно заполнить бин, и передать его в DAO на создание, обновление, удаление
        boolean ok = false;
        PrintWriter out = resp.getWriter();
        Users users = new Users();
        try {
            users.setLogin(req.getParameter("Login"));
            users.setPassword(req.getParameter("Password"));
            users.setName(req.getParameter("Name"));
            users.setSurname(req.getParameter("Surname"));
            users.setMail(req.getParameter("Mail"));
            users.setPhonenumber(req.getParameter("Phonenumber"));
            Integer role=Integer.parseInt(req.getParameter("radios"));
            if (role.equals(1)) users.setFKRole(1);else users.setFKRole(2);

            //bean получен. Теперь в зависимости от ID добавим обновим или удалим запись в БД.
            UsersDAO usersDAO = new UsersDAO();
            if (0 == users.getIdUsers()) {
                out.println("<body>Create. <br>");
                ok = usersDAO.create(users);
                resp.sendRedirect("logupsuccess.jsp");
            }
            if (0 < users.getIdUsers()) {
                ok = usersDAO.update(users);
            }
            if (0 > users.getIdUsers()) {
                users.setIdUsers(-1 * users.getIdUsers());
                ok = usersDAO.delete(users);
            }
            if (!ok) throw new Exception("СБОЙ!");
            //операция завершена. Пока просто выведем в браузер результат без редиректа на заготовленную страницу
            {
                out.println("OK. <br>");
            }

        } catch (Exception e) {
            out.println("Error. <br>");
        }
        out.flush();
    }
}

