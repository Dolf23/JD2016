package projects.chatovich.servlets.JD03_02.DB_it_academy;

/**
 * for table cities
 */
public class City {

    String city;
    int id_city;

    public City(String city) {
        this.city = city;
    }

    public City(){

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId_city() {
        return id_city;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }

    @Override
    public String toString() {
        return "City" +
                "";
    }
}
