package projects.baranova.servlets.DAO;

import java.sql.SQLException;

public class Rooms {

    private int idRooms;
    private String roomNumber;
    private int guestQuantity;
    private int fkfirstbedsize;
    private int fksecondbedsize;
    private int fkSeaview;
    private int floor;
    private int price;

    public Rooms(){
    }

    public Rooms(String roomNumber, int guestQuantity, int fkFirstBedSize, int FKSecondBedSize, int FKSeaview, int floor, int price) {
        this.roomNumber = roomNumber;
        this.guestQuantity = guestQuantity;
        this.fkfirstbedsize = fkFirstBedSize;
        this.fksecondbedsize = FKSecondBedSize;
        this.fkSeaview = FKSeaview;
        this.floor = floor;
        this.price = price;
    }

    public int getIdRooms() {return idRooms;}
    public String getRoomNumber() {return roomNumber;}
    public int getGuestQuantity() {return guestQuantity;}
    public int getFkfirstbedsize() {return fkfirstbedsize;}
    public int getFksecondbedsize() {return fksecondbedsize;}
    public int getFkSeaview() {return fkSeaview;}
    public int getFloor() {return floor;}
    public int getPrice() {return price;}

    public void setIdRooms(int idRooms) {this.idRooms = idRooms;}
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;}
    public void setGuestQuantity(int guestQuantity) {
        this.guestQuantity = guestQuantity;}
    public void setFkfirstbedsize(int fkfirstbedsize) {this.fkfirstbedsize = fkfirstbedsize;}
    public void setFksecondbedsize(int fksecondbedsize) {this.fksecondbedsize = fksecondbedsize;}
    public void setFkSeaview(int fkSeaview) {this.fkSeaview = fkSeaview;}
    public void setFloor(int floor) {
        this.floor = floor;}
    public void setPrice(int price) {
        this.price = price;}


    @Override
    public String toString() {
        String res="";
        try {
            res="Room{" +
                    "id=" + idRooms +
                    ", Number of room='" + roomNumber + '\'' +
                    ", guestquantity='" + guestQuantity + '\'' +
                    ", first bed='"+new BedSizeDAO().getBedSize(fkfirstbedsize)+'\''+
                    ", second bed='"+new BedSizeDAO().getBedSize(fksecondbedsize)+'\''+
                    ", seaview='"+new SeaviewDAO().getSeaview(fkSeaview)+'\''+
                    ", floor='" + floor + '\'' +
                    ", price=" + price +
                    '}';
        } catch (SQLException e) {
            res=e.toString();
        }
        return res;
    }
}
