package projects.chatovich.servlets.DAO;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Interface DAO
 */
public interface InterfaceDAO <T> {

    boolean create(T t) throws SQLException;
    boolean update(T t) throws SQLException;
    boolean delete(T t) throws SQLException;
    T read(int id) throws SQLException;
    HashMap<Integer, T> getAll(String where) throws SQLException;
    void showTable() throws SQLException;
}
