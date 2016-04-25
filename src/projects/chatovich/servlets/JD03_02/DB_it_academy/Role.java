package projects.chatovich.servlets.JD03_02.DB_it_academy;

/**
 * for table role
 */
public class Role {

    int id_role;
    String role_type;

    public Role(String role_type) {
        this.role_type = role_type;
    }

    public String getRole_type() {
        return role_type;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public void setRole_type(String role_type) {
        this.role_type = role_type;
    }
}
