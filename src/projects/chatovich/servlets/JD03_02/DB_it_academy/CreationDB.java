package projects.chatovich.servlets.JD03_02.DB_it_academy;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Creation
 */
public class CreationDB {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {

            SQL_Queries.createTable(statement);
            SQL_Queries.insertData(statement);
            System.out.println("Database it-academy was created");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
