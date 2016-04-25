package projects.chatovich.servlets.JD03_02.DB_it_academy;

import projects.chatovich.servlets.DAO.CityDAO;
import projects.chatovich.servlets.DAO.RoleDAO;

import java.sql.SQLException;
import java.sql.Timestamp;



/**
 * for table users
 */
public class User {

    String name;
    String surname;
    String login;
    String password;
    Timestamp birthdate;
    int role = 1;
    String email;
    int city;
    String describtion;
    int id;
    int age;

    public User(String name, String surname, String login, String password, Timestamp birthdate, int role,
                String email, int city, String describtion) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.birthdate = birthdate;
        this.role = role;
        this.email = email;
        this.city = city;
        this.describtion = describtion;
    }

    public User(){

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Timestamp getBirthdate() {
        return birthdate;
    }

    public int getRole() {
        return role;
    }

    public int getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getDescribtion() {
        return describtion;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setBirthdate(Timestamp birthdate) {
        this.birthdate = birthdate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        String res;
        try {

            res="User{" +
                    "id = " + id +
                    ", name = " + name +
                    ", surname = " + surname +
                    ", birthdate  = " + birthdate +
                    ", login = " + login +
                    ", password = " + password +
                    ", email = " + email +
                    ", role = " + new RoleDAO().getRole(role) +
                    ", city = " + new CityDAO().getCity(city) +
                    '}';
        } catch (SQLException e) {
            res=e.toString();
        }
        return res;
    }
}
