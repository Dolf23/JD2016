package projects.chatovich.servlets.JD03_02.DB_it_academy;

/**
 * for table feedbacks
 */
public class Feedback {

    int id_feedback;
    int feedback_from;
    int feedback_to;
    String feedback_text;

    public Feedback(String feedback_text, int feedback_to, int feedback_from) {
        this.feedback_text = feedback_text;
        this.feedback_to = feedback_to;
        this.feedback_from = feedback_from;
    }

    public Feedback() {

    }

    public int getId_feedback() {
        return id_feedback;
    }

    public int getFeedback_from() {
        return feedback_from;
    }

    public int getFeedback_to() {
        return feedback_to;
    }

    public String getFeedback_text() {
        return feedback_text;
    }

    public void setId_feedback(int id_feedback) {
        this.id_feedback = id_feedback;
    }

    public void setFeedback_from(int feedback_from) {
        this.feedback_from = feedback_from;
    }

    public void setFeedback_to(int feedback_to) {
        this.feedback_to = feedback_to;
    }

    public void setFeedback_text(String feedback_text) {
        this.feedback_text = feedback_text;
    }

    @Override
    public String toString() {
        return "from "+feedback_from+" to "
                +feedback_to+" text "+feedback_text;
    }
}
