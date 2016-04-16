package projects.baranova.servlets.DAO;


import java.sql.Connection;
import java.sql.Statement;

class DAO {

    private static DAO dao; //синглтон для DAO

    static DAO getDAO() {   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null) {
            dao = new DAO();    //в момент создания DAO удобно создавать соединения.
                                //Но потом трудно их уничтожать. Нужно это делать явно из кода.
        }
        return dao;
    }

    static void closeDAO() {   //метод, который уничтожает DAO
        dao = null; //Тут можно тоже закрывать соединение.
    }

    //Create Update Delete
    static int executeUpdate(String sql) {
        //System.out.println("--- Sql="+sql); //отладка
        int result = -1;
        try (Connection connection = Cnn.getConnection();
             Statement statement = connection.createStatement();) {
            result = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

