package projects.baranova.servlets.DAO;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomsDAO extends DAO implements InterfaceDAO<Rooms> {

    @Override
    public List<Rooms> getAll(String Where){
        List<Rooms> roomslist=new ArrayList<>();
        String sql="SELECT * FROM Rooms "+Where+" ;";
        try (Connection connection = Cnn.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()){
                Rooms rooms = new Rooms();
                rooms.setIdRooms(rs.getInt("idRooms"));
                rooms.setRoomNumber(rs.getString("RoomNumber"));
                rooms.setFkfirstbedsize(rs.getInt("FKFirstBedSize"));
                rooms.setFksecondbedsize(rs.getInt("FKSecondBedSize"));
                rooms.setFkSeaview(rs.getInt("FKSeaview"));
                rooms.setFloor(rs.getInt("Floor"));
                rooms.setPrice(rs.getInt("Price"));
                rooms.setGuestQuantity(rs.getInt("GuestQuantity"));
                roomslist.add(rooms);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    return roomslist;
    }

    @Override
    public Rooms read(int id) {
        List<Rooms> rooms = getAll("WHERE idRooms=" + id + " LIMIT 0,1");
        if (rooms.size() > 0) {
            return rooms.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Rooms rooms){
        String sql = String.format(
                "insert INTO Rooms(RoomNumber,GuestQuantity,FKFirstBedSize,FKSecondBedSize,FKSeaview,Floor,Price)" +
                        " values('%s', %d, %d, %d, %d, %d, %d);",
                rooms.getRoomNumber(), rooms.getGuestQuantity(), rooms.getFkfirstbedsize(),rooms.getFksecondbedsize(), rooms.getFkSeaview(), rooms.getFloor(), rooms.getPrice()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean update(Rooms rooms){
        String sql=String.format(
        "UPDATE Rooms SET RoomNumber = '%s', GuestQuantity = %d ,FKFirstBedSize= %d, FKSecondBedSize= %d, FKSeaview= %d, Floor = %d, Price = %d WHERE Rooms.idRooms = %d",
                rooms.getRoomNumber(), rooms.getGuestQuantity(), rooms.getFkfirstbedsize(),rooms.getFksecondbedsize(), rooms.getFkSeaview(), rooms.getFloor(), rooms.getPrice(), rooms.getIdRooms()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Rooms rooms) {
        String sql = String.format(
                "DELETE FROM Rooms WHERE Rooms.idRooms = %d;", rooms.getIdRooms()
        );
        return (0 < executeUpdate(sql));
    }
}
