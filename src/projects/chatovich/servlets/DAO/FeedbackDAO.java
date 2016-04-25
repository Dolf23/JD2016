package projects.chatovich.servlets.DAO;

import projects.chatovich.servlets.JD03_02.DB_it_academy.Feedback;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * FeedbackDAO
 */
public class FeedbackDAO extends DAO implements InterfaceDAO<Feedback> {


    @Override
    public boolean create(Feedback feedback) throws SQLException {
        String sql = String.format("insert into feedbacks (feedback_from, feedback_to, feedback_text) " +
                        "values ('%d','%d','%s' );", feedback.getFeedback_from(), feedback.getFeedback_to(),
                         feedback.getFeedback_text());

        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean update(Feedback feedback) throws SQLException {
        String sql = String.format(
                "UPDATE feedbacks SET feedback_from = '%d', feedback_to = '%d', feedback_text = '%s' " +
                        "WHERE id_feedback = %d", feedback.getFeedback_from(), feedback.getFeedback_to(),
                feedback.getFeedback_text(), feedback.getId_feedback());

        return (0 < executeUpdate(sql));    }

    @Override
    public boolean delete(Feedback feedback) throws SQLException {
        String sql = String.format(
                "DELETE FROM feedbacks WHERE id_feedback = %d;", feedback.getId_feedback());

        return (0 < executeUpdate(sql));
    }

    @Override
    public Feedback read(int id) throws SQLException {
        HashMap<Integer,Feedback> feedbacks = getAll("WHERE id_feedback=" + id);
        if (feedbacks.size() > 0) {
            return feedbacks.get(0);
        } else
            return null;
    }

    @Override
    public HashMap<Integer, Feedback> getAll(String where) throws SQLException {
        HashMap <Integer, Feedback> feedbacks = new HashMap<>();
        String sql = "SELECT * FROM feedbacks " + where + " ;";
        /*try (
                Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
                Statement statement = connection.createStatement()
        ) {*/
        Statement statement = DAO.getStatement();
        ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Feedback feedback = new Feedback();
                feedback.setId_feedback(rs.getInt("id_feedback"));
                feedback.setFeedback_from(rs.getInt("feedback_from"));
                feedback.setFeedback_to(rs.getInt("feedback_to"));
                feedback.setFeedback_text(rs.getString("feedback_text"));
                feedbacks.put(rs.getInt("id_feedback"),feedback);

            }
        /*} catch (SQLException e) {
            e.printStackTrace();
        }*/
        return feedbacks;
    }

    @Override
    public void showTable() throws SQLException {
        HashMap<Integer, Feedback> feedbacks = getAll("");
        System.out.println("FEEDBACKS");
        for (Map.Entry<Integer, Feedback> entry : feedbacks.entrySet()) {
            String s = "Feedback "+entry.getKey() + ": "+entry.getValue();
            System.out.println(s);
        }
    }
}
