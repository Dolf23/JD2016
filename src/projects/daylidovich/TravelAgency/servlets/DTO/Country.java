package projects.daylidovich.TravelAgency.servlets.DTO;

public class Country {
    private int id;
    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Country {id=" + id + ", Country=" + country + "}";
    }
}
