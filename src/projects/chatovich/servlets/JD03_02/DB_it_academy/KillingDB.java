package projects.chatovich.servlets.JD03_02.DB_it_academy;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Drop DB
 */
public class KillingDB {

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement = connection.createStatement()) {

            //statement.executeUpdate("drop table feedbacks;");
            statement.executeUpdate("drop table profiles;");
            statement.executeUpdate("drop table cities;");
            statement.executeUpdate("drop table users;");
            statement.executeUpdate("drop table role;");
            //statement.executeUpdate("drop database (it-academy);");

            System.out.println("Tables from DB it-academy were deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
