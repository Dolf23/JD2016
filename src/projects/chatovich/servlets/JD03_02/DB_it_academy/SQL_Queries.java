package projects.chatovich.servlets.JD03_02.DB_it_academy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

/**
 * SQL queries
 */
public class SQL_Queries {

    public static void createSchema (Statement statement) throws Exception {
        statement.executeUpdate("CREATE SCHEMA `it-academy` DEFAULT CHARACTER SET utf8 ;");
    }

    public static void createTable(Statement statement) throws Exception {

        statement.executeUpdate("CREATE TABLE `it-academy`.`role` (\n" +
                "  `id_role` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `role_type` VARCHAR(45) NOT NULL,\n" +
                "  PRIMARY KEY (`id_role`))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");


        statement.executeUpdate("CREATE TABLE `it-academy`.`cities` (\n" +
                "  `id_city` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `city` VARCHAR(45) NOT NULL,\n" +
                "  PRIMARY KEY (`id_city`))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");

        statement.executeUpdate("CREATE TABLE `it-academy`.`users` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NOT NULL,\n" +
                "  `surname` VARCHAR(45) NOT NULL,\n" +
                "  `login` VARCHAR(45) NOT NULL,\n" +
                "  `password` VARCHAR(45) NOT NULL,\n" +
                "  `birth_date` TIMESTAMP(6) NOT NULL,\n" +
                "  `id_role` INT NOT NULL,\n" +
                "  `email` VARCHAR(45) NULL,\n" +
                "  `id_city` INT NOT NULL,\n" +
                "  `describtion` VARCHAR(300) NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  INDEX `id_role_idx` (`id_role` ASC),\n" +
                "  INDEX `id_city_idx` (`id_city` ASC),\n" +
                "  CONSTRAINT `id_role`\n" +
                "    FOREIGN KEY (`id_role`)\n" +
                "    REFERENCES `it-academy`.`role` (`id_role`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION,\n" +
                "  CONSTRAINT `id_city`\n" +
                "    FOREIGN KEY (`id_city`)\n" +
                "    REFERENCES `it-academy`.`cities` (`id_city`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION)\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;");


        statement.executeUpdate("CREATE TABLE `it-academy`.`profiles` (\n" +
                "  `id_profile` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `id_user` INT NOT NULL,\n" +
                "  `describtion` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`id_profile`),\n" +
                "  INDEX `id_user_idx` (`id_user` ASC),\n" +
                "  CONSTRAINT `id_user`\n" +
                "    FOREIGN KEY (`id_user`)\n" +
                "    REFERENCES `it-academy`.`users` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION)\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");


        statement.executeUpdate("CREATE TABLE `it-academy`.`feedbacks` (\n" +
                "  `id_feedback` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `feedback_from` INT NOT NULL,\n" +
                "  `feedback_to` INT NOT NULL,\n" +
                "  `feedback_text` TEXT(1000) NOT NULL,\n" +
                "  PRIMARY KEY (`id_feedback`),\n" +
                "  INDEX `feedback_from_idx` (`feedback_from` ASC),\n" +
                "  INDEX `feedback_to_idx` (`feedback_to` ASC),\n" +
                "  CONSTRAINT `feedback_from`\n" +
                "    FOREIGN KEY (`feedback_from`)\n" +
                "    REFERENCES `it-academy`.`users` (`id`)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE,\n" +
                "  CONSTRAINT `feedback_to`\n" +
                "    FOREIGN KEY (`feedback_to`)\n" +
                "    REFERENCES `it-academy`.`users` (`id`)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE)\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");
    }

    public static void insertData (Statement statement) throws SQLException {

        statement.executeUpdate("insert into role (role_type) values ('user');");
        statement.executeUpdate("insert into role (role_type) values ('admin');");

        statement.executeUpdate("insert into cities (city) values ('Minsk');");
        statement.executeUpdate("insert into cities (city) values ('Moscow');");
        statement.executeUpdate("insert into cities (city) values ('New York');");
        statement.executeUpdate("insert into cities (city) values ('Florence');");
        statement.executeUpdate("insert into cities (city) values ('London');");
        statement.executeUpdate("insert into cities (city) values ('Praga');");

        statement.executeUpdate("insert into users (name, surname, login, password, birth_date, id_role, email, id_city) " +
                "values ('Kiryl','Laurynau','laurynau','yultos','1986-05-26',1, 'kiryl.laurynau@gmail.com', 4);");
        statement.executeUpdate("insert into users (name, surname, login, password, birth_date, id_role,id_city) " +
                "values ('Ivan','Ivanov','ivanov','yultos','1990-01-05',1, 2);");
        statement.executeUpdate("insert into users (name, surname, login, password, birth_date, id_role, email,id_city) " +
                "values ('John','Smith','smith','yultos','1980-10-20',1, 'smith@gmail.com', 3);");
        statement.executeUpdate("insert into users (name, surname, login, password, birth_date, id_role, email, id_city) " +
                "values ('Yuliya','Chatovich','chatovich','yultos','1988-07-30',2, 'chatovich@gmail.com', 1);");



        /*statement.executeUpdate("insert into profiles (id_user,id_city,description) " +
                "values ((select id from users where name='Yuliya')," +
                "(select id_city from cities where city='Minsk'), 'Sunny 2-rooms apartment on Kolasa str');");

        statement.executeUpdate("insert into feedbacks (feedback_from, feedback_to, feedback_text) " +
                "values (4,1,'cute guy with excellent sence of humour and a really comfortable flat')");*/

    }

    public static void showTables (Statement statement) throws SQLException {

        Calendar today = Calendar.getInstance();
        ResultSet resultSet = statement.executeQuery("select * from users;");
        while (resultSet.next()){
            Calendar birthday = Calendar.getInstance();
            birthday.setTime(resultSet.getDate("birth_date"));
            int age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
            System.out.println(resultSet.getString("name")+" "+resultSet.getString("surname")+", age "+age);
        }

    }
}
