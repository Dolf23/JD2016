package projects.chatovich.servlets.JD03_02.DB_it_academy;

/**
 * for table profiles
 */
public class Profile {

    int id_user;
    int id_city;
    String description;

    public Profile(int id_user, int id_city, String description) {
        this.id_user = id_user;
        this.id_city = id_city;
        this.description = description;
    }

    public Profile() {
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_city() {
        return id_city;
    }

    public String getDescription() {
        return description;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
