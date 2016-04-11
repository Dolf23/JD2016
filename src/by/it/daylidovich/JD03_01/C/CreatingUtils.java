package by.it.daylidovich.JD03_01.C;

import java.sql.SQLException;
import java.sql.Statement;

public class CreatingUtils {
    public static void createTable(Statement statement) throws SQLException {

        statement.executeUpdate("CREATE TABLE role_d (\n" +
                "id INT NOT NULL AUTO_INCREMENT,\n" +
                "Role VARCHAR(50) NOT NULL,\n" +
                "PRIMARY KEY (id))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");

        statement.executeUpdate("CREATE TABLE countries_d (\n" +
                "id INT AUTO_INCREMENT,\n" +
                "Country VARCHAR(50) NOT NULL,\n" +
                "PRIMARY KEY (id))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");

        statement.executeUpdate("CREATE TABLE transport_d (\n" +
                "id INT AUTO_INCREMENT,\n" +
                "Transport VARCHAR(50) NOT NULL,\n" +
                "PRIMARY KEY (id))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");

        statement.executeUpdate("CREATE TABLE type_tour_d (\n" +
                "id INT AUTO_INCREMENT,\n" +
                "Type_tour VARCHAR(50) NOT NULL,\n" +
                "PRIMARY KEY (id))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");

        statement.executeUpdate("CREATE TABLE type_hotel_d (\n" +
                "id INT AUTO_INCREMENT,\n" +
                "Type_hotel VARCHAR(50) NOT NULL,\n" +
                "PRIMARY KEY (id))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");

        statement.executeUpdate("CREATE TABLE food_complex_d (\n" +
                "id INT AUTO_INCREMENT,\n" +
                "Food_complex VARCHAR(50) NOT NULL,\n" +
                "PRIMARY KEY (id))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");

        statement.executeUpdate("CREATE TABLE users_d (\n" +
                "id INT AUTO_INCREMENT,\n" +
                "Name VARCHAR(50) NOT NULL,\n" +
                "Surname VARCHAR(50) NOT NULL,\n" +
                "Email VARCHAR(50) NULL,\n" +
                "Login VARCHAR(50) NOT NULL,\n" +
                "Password VARCHAR(50) NOT NULL,\n" +
                "FK_role INT NOT NULL,\n" +
                "PRIMARY KEY (id),\n" +
                "FOREIGN KEY (FK_role)\n" +
                "  REFERENCES role_d (id))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");

        statement.executeUpdate("CREATE TABLE tours_d (\n" +
                "id INT AUTO_INCREMENT,\n" +
                "FK_country int(3) NOT NULL,\n" +
                "FK_type_tour int(1) NOT NULL,\n" +
                "FK_transport int(1) NOT NULL,\n" +
                "FK_type_hotel int(1) NOT NULL,\n" +
                "FK_food_complex int(1) NOT NULL,\n" +
                "Cost int NOT NULL,\n" +
                "Discount int NOT NULL,\n" +
                "PRIMARY KEY (id),\n" +
                "FOREIGN KEY (FK_country)\n" +
                "    REFERENCES countries_d (id),\n" +
                "FOREIGN KEY (FK_type_tour)\n" +
                "    REFERENCES type_tour_d (id),\n" +
                "FOREIGN KEY (FK_transport)\n" +
                "    REFERENCES transport_d (id),\n" +
                "FOREIGN KEY (FK_type_hotel)\n" +
                "    REFERENCES type_hotel_d (id),\n" +
                "FOREIGN KEY (FK_food_complex)\n" +
                "    REFERENCES food_complex_d (id))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");

            statement.executeUpdate("CREATE TABLE type_action_d (\n" +
                    "id INT AUTO_INCREMENT,\n" +
                    "Type_action VARCHAR(50) NOT NULL,\n" +
                    "PRIMARY KEY (id))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;\n");

            statement.executeUpdate("CREATE TABLE action_d (\n" +
                    "id INT AUTO_INCREMENT,\n" +
                    "FK_action int(3) NOT NULL,\n" +
                    "FK_user int(3) NOT NULL,\n" +
                    "FK_tour int(3) NOT NULL,\n" +
                    "PRIMARY KEY (id),\n" +
                    "FOREIGN KEY (FK_action)\n" +
                    "    REFERENCES type_action_d (id),\n" +
                    "FOREIGN KEY (FK_user)\n" +
                    "    REFERENCES users_d (id),\n" +
                    "FOREIGN KEY (FK_tour)\n" +
                    "    REFERENCES tours_d (id))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;\n");
    }

    public static void deleteTable(Statement statement) throws SQLException {
            /*statement.executeUpdate("ALTER TABLE users_d DROP FOREIGN KEY FK_role");
            statement.executeUpdate("ALTER TABLE users_d DROP FOREIGN KEY FK_food_complex");
            statement.executeUpdate("ALTER TABLE users_d DROP FOREIGN KEY FK_type_hotel");
            statement.executeUpdate("ALTER TABLE users_d DROP FOREIGN KEY FK_transport");
            statement.executeUpdate("ALTER TABLE users_d DROP FOREIGN KEY FK_type_tour");
            statement.executeUpdate("ALTER TABLE tours_d DROP FOREIGN KEY FK_country");
            statement.executeUpdate("ALTER TABLE action_d DROP FOREIGN KEY FK_action");
            statement.executeUpdate("ALTER TABLE users_d DROP FOREIGN KEY FK_user");
            statement.executeUpdate("ALTER TABLE users_d DROP FOREIGN KEY FK_tour");*/
            statement.execute("DROP TABLE IF EXISTS role_d ");
            statement.executeUpdate("DROP TABLE IF EXISTS countries_d");
            statement.executeUpdate("DROP TABLE IF EXISTS transport_d");
            statement.executeUpdate("DROP TABLE IF EXISTS type_tour_d");
            statement.executeUpdate("DROP TABLE IF EXISTS type_hotel_d");
            statement.executeUpdate("DROP TABLE IF EXISTS food_complex_d");
            statement.executeUpdate("DROP TABLE IF EXISTS type_action_d");
            statement.executeUpdate("DROP TABLE IF EXISTS users_d");
            statement.executeUpdate("DROP TABLE IF EXISTS tours_d");
            statement.executeUpdate("DROP TABLE IF EXISTS action_d");

    }

    public static void insertDataToTables(Statement statement) throws SQLException {
        statement.executeUpdate("insert into role_d(Role)\n" +
                "values ('administrator'),\n" +
                "('user')");

        statement.executeUpdate("insert into transport_d(Transport)\n" +
                "values\n" +
                "('aircraft'),\n" +
                "('water transport'),\n" +
                "('railway transport'),\n" +
                "('bus'),\n" +
                "('without transport')");

        statement.executeUpdate("insert into type_tour_d(Type_tour)\n" +
                "values\n" +
                "('relaxing'),\n" +
                "('traveling'),\n" +
                "('shopping')");

        statement.executeUpdate("insert into type_hotel_d(Type_hotel)\n" +
                "values\n" +
                "('3'),\n" +
                "('3+'),\n" +
                "('4'),\n" +
                "('4+'),\n" +
                "('5'),\n" +
                "('5+')");

        statement.executeUpdate("insert into food_complex_d(Food_complex)\n" +
                "values\n" +
                "('bed and breakfast'),\n" +
                "('breakfast and dinner'),\n" +
                "('breakfast lunch and dinner'),\n" +
                "('all inclusive'),\n" +
                "('without food')");

        statement.executeUpdate("insert into countries_d(Country)\n" +
                "values\n" +
                "('Egypt'),\n" +
                "('Spain'),\n" +
                "('Italy'),\n" +
                "('Montenegro'),\n" +
                "('Bulgaria')");

        statement.executeUpdate("insert into users_d(Name, Surname, Email, Login, Password, FK_Role)\n" +
                "values\n" +
                "('Dmitry', 'Dailidovich', 'dmitry.dailidovich@gmail.com', 'Dolf23', '123', 1),\n" +
                "('Ivan', 'Ivanov', 'Ivan.Ivanov@mail.ru', 'Ivan93', '1111', 2),\n" +
                "('Anastasia', 'Poleschyk', 'nastia95@inbox.ru', 'Nastenka', '2306' , 2)");

        statement.executeUpdate("insert into type_action_d(Type_action)\n" +
                "values\n" +
                "('Discount'),\n" +
                "('Reserve')");
    }
}
