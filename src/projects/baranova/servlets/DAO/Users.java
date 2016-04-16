package projects.baranova.servlets.DAO;


import java.sql.SQLException;

public class Users {

    private  int idUsers;
    private String Login;
    private String Password;
    private String Name;
    private String Surname;
    private String Phonenumber;
    private String Mail;
    private int FKRole;

    public Users(){
    }

    public Users(String Login, String Password, String Name, String Surname, String Phonenumber, String Mail){
        this.Login=Login;
        this.Password=Password;
        this.Name=Name;
        this.Surname=Surname;
        this.Phonenumber=Phonenumber;
        this.Mail=Mail;
    }


    public void setIdUsers(int idUsers) {this.idUsers = idUsers;}
    public void setLogin(String login) {Login = login;}
    public void setPassword(String password) {Password = password;}
    public void setName(String name) {Name = name;}
    public void setSurname(String surname) {Surname = surname;}
    public void setPhonenumber(String phonenumber) {Phonenumber = phonenumber;}
    public void setMail(String mail) {Mail = mail;}
    public void setFKRole(int FKRole) {this.FKRole = FKRole;}

    public int getIdUsers() {return idUsers;}
    public String getLogin() {return Login;}
    public String getPassword() {return Password;}
    public String getName() {return Name;}
    public String getSurname() {return Surname;}
    public String getPhonenumber() {return Phonenumber;}
    public String getMail() {return Mail;}
    public int getFKRole() {return FKRole;}


    @Override
    public String toString() {
        String res="";
        try {
            res="User{" +
                    "id=" + idUsers +
                    ", login='" + Login + '\'' +
                    ", password='" + Password + '\'' +
                    ", name='"+Name+'\''+
                    ", surname='"+Surname+'\''+
                    ", phonenumber='"+Phonenumber+'\''+
                    ", email='" + Mail + '\'' +
                    ", Role=" + new RoleDAO().getRole(FKRole) +
                    '}';
        } catch (SQLException e) {
            res=e.toString();
        }
        return res;
    }
}
