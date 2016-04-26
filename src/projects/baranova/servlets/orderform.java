package projects.baranova.servlets;

import projects.baranova.servlets.DAO.Orders;
import projects.baranova.servlets.DAO.OrdersDAO;
import projects.baranova.servlets.DAO.Users;
import projects.baranova.servlets.DAO.UsersDAO;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class orderform extends HttpServlet {

    public static void main(String[] args) throws SQLException {

        Orders orders = new Orders();
        orders.setGuestQuantity(1);
        orders.setDaysQuantity(5);
        orders.setFkUser(2);
        orders.setFkReservedRoom(3);
        System.out.print(orders);
        OrdersDAO ordersDAO = new OrdersDAO();
        ordersDAO.create(orders);
        List <Orders> orderses=ordersDAO.getAll("");
        for (Orders orders1:orderses){
            System.out.println(orders1);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Cookie ck[]=req.getCookies();
        String login="";
        if (ck!=null){
            for (Cookie cookie:ck){
                if (cookie.getName().equals("Login")){
                    login=cookie.getValue();
                }
            }
        }

        List<Users> loginuser=new UsersDAO().getAll("WHERE Login='"+login+"'");
        int fkUser=0;
        for (Users users:loginuser){
            fkUser=users.getIdUsers();
        }
        OrdersDAO ordersDAO=new OrdersDAO();
        List<Orders> listOrders=ordersDAO.getAll("WHERE FKUser="+fkUser);

        //передаем собранные данные в jsp-представление для вывода их в html-виде
        //основное тут это объект listUser - коллекция пользователей
        req.setAttribute("listOrders", listOrders);
        req.getRequestDispatcher("cancelreservations.jsp").forward(req,resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        boolean ok = false;
        String message="Operation of ";
        Orders orders=new Orders();
        try {
            Cookie ck[]=req.getCookies();
            String login="";
            if (ck!=null){
                for (Cookie cookie:ck){
                    if (cookie.getName().equals("Login")){
                        login=cookie.getValue();
                    }
                }
            }

            List<Users> loginuser=new UsersDAO().getAll("WHERE Login='"+login+"'");
            int fkUser=0;
            for (Users users:loginuser){
                fkUser=users.getIdUsers();
            }
            orders.setIdOrder(Integer.parseInt(req.getParameter("idOrder")));
            try {
                orders.setDaysQuantity(Integer.parseInt(req.getParameter("daysQuantity")));
                orders.setGuestQuantity(Integer.parseInt(req.getParameter("guestQuantity")));
                orders.setFkUser(fkUser);
            }catch (Exception e) {
            //LOG
            }

            //bean получен. Теперь в зависимости от ID добавим обновим или удалим запись в БД.
            OrdersDAO ordersDAO = new OrdersDAO();
            if (0 == orders.getIdOrder()) {
                message=message+" creating order "+orders+" ";
                ok = ordersDAO.create(orders);
            }
            if (0 < orders.getIdOrder()) {
                message=message+" updating order "+orders+" ";
                ok = ordersDAO.update(orders);
            }
            if (0 > orders.getIdOrder()) {
                message=message+" deleting "+orders+" ";
                orders.setIdOrder(-1 * orders.getIdOrder());
                ok = ordersDAO.delete(orders);
            }
            if (!ok) throw new Exception("СБОЙ!");
            //операция завершена. Пока просто выведем в браузер результат без редиректа на заготовленную страницу
            {
                message=message.concat("успешно завершена.");
            }

        } catch (Exception e) {
            message=message.concat("<b>failed</b>.<br>"+e);
        }
    req.setAttribute("message", message);
    req.getRequestDispatcher("message.jsp").forward(req,resp);
    }
}

