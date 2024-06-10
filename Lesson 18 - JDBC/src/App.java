import java.sql.*;

public class App {
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/college"; // Specify the database name
    static final String USER = "root";
    static final String PASS = "Amey1234";
 
    public static void main(String[] args) {
       // Open a connection
       try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
          System.out.println("Connection successful");
 
          // Create a statement
          Statement stmt = conn.createStatement();
 
          // Execute the query
          String sql = "SELECT * FROM course";
          ResultSet rs = stmt.executeQuery(sql);
 
          // Process the results
          while (rs.next()) {
             int studId = rs.getInt("stud_id");
             String courseName = rs.getString("course_name");
             System.out.println("Student ID: " + studId + ", Course Name: " + courseName);
          }
 
          // Close the result set and statement
          rs.close();
          stmt.close();
       } catch (SQLException e) {
          e.printStackTrace();
       }
    }
 }
