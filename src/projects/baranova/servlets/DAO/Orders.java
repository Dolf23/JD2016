package projects.baranova.servlets.DAO;


public class Orders {

    private int idOrder;
    private int fkUser;
    private int daysQuantity;
    private int guestQuantity;
    private int fkReservedRoom;

    public Orders(){
    }

    public Orders(int idOrder, int fkUser, int daysQuantity, int guestQuantity) {
        this.idOrder = idOrder;
        this.fkUser =fkUser;
        this.daysQuantity =daysQuantity;
        this.guestQuantity = guestQuantity;
    }

    public int getIdOrder() {return idOrder;}
    public int getFkUser() {return fkUser;}
    public int getDaysQuantity() {return daysQuantity;}
    public int getGuestQuantity() {return guestQuantity;}
    public int getFkReservedRoom() {return fkReservedRoom;}

    public void setIdOrder(int idOrder) {this.idOrder = idOrder;}
    public void setFkUser(int fkUser) {this.fkUser = fkUser;}
    public void setDaysQuantity(int daysQuantity) {
        this.daysQuantity = daysQuantity;}
    public void setGuestQuantity(int guestQuantity) {
        this.guestQuantity = guestQuantity;}
    public void setFkReservedRoom(int fkReservedRoom) {this.fkReservedRoom = fkReservedRoom;}

    @Override
    public String toString() {
        String res="";
        if (fkReservedRoom !=0) {
            res = "Order{" +
                    "idOrder=" + idOrder +
                    ", User='" + new UsersDAO().read(fkUser).getLogin() + '\'' +
                    ", days quantity='" + daysQuantity + '\'' +
                    ", guest quantity='" + guestQuantity + '\'' +
                    ", reserved room='" + new RoomsDAO().read(fkReservedRoom).getRoomNumber() + '\'' +
                    '}';
        } else {
            res = "Order{" +
                    "idOrder=" + idOrder +
                    ", User='" + new UsersDAO().read(fkUser).getLogin() + '\'' +
                    ", days quantity='" + daysQuantity + '\'' +
                    ", guest quantity='" + guestQuantity +'\''+
                    '}';
        }
        return res;
    }
}
