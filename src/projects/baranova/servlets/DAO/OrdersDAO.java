package projects.baranova.servlets.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO extends DAO implements InterfaceDAO<Orders> {

    @Override
    public List<Orders> getAll(String Where){
        List<Orders> orderslist=new ArrayList<>();
        String sql="SELECT * FROM Orders "+Where+" ;";

        try (Connection connection = Cnn.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()){
                Orders orders = new Orders();
                orders.setIdOrder(rs.getInt("idOrder"));
                orders.setDaysQuantity(rs.getInt("daysQuantity"));
                orders.setGuestQuantity(rs.getInt("guestQuantity"));
                orders.setFkUser(rs.getInt("fkUser"));
                orders.setFkReservedRoom(rs.getInt("fkReservedRoom"));
                orderslist.add(orders);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    return orderslist;
    }

    @Override
    public Orders read(int id) {
        List<Orders> orders = getAll("WHERE idOrder=" + id + " LIMIT 0,1");
        if (orders.size() > 0) {
            return orders.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Orders orders){
        String sql = String.format(
                "insert INTO Orders(FKUser,GuestQuantity,DaysQuantity)" +
                        " values(%d, %d, %d);",
                orders.getFkUser(), orders.getGuestQuantity(), orders.getDaysQuantity()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean update(Orders orders){
        String sql=String.format(
        "UPDATE Orders SET FKUser = %d, GuestQuantity= %d, DaysQuantity = %d , FKReservedRoom= %d, idOrder= %d WHERE Rooms.idOrder = %d",
                orders.getFkUser(), orders.getDaysQuantity(), orders.getGuestQuantity(),orders.getFkReservedRoom(), orders.getIdOrder(), orders.getIdOrder()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Orders orders) {
        String sql = String.format(
                "DELETE FROM Orders WHERE Orders.idOrder = %d;", orders.getIdOrder()
        );
        return (0 < executeUpdate(sql));
    }
}
