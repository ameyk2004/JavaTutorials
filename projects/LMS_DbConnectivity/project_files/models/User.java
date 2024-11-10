package projects.LMS_DbConnectivity.project_files.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private String role = "borrower"; 
    private BigDecimal fine = BigDecimal.ZERO;
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    public User(int id, String name, String email, String password, String role, BigDecimal fine, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role != null ? role : "borrower";
        this.fine = fine != null ? fine : BigDecimal.ZERO;
        this.createdAt = createdAt != null ? createdAt : new Timestamp(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public BigDecimal getFine() {
        return fine;
    }

    public void setFine(BigDecimal fine) {
        this.fine = fine;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", email='" + email + '\'' +
               ", password='" + password + '\'' +
               ", role='" + role + '\'' +
               ", fine=" + fine +
               ", createdAt=" + createdAt +
               '}';
    }
}
