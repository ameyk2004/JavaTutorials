// Queries in JDBC 

// DATABASE Info
// Name : college
// Table name : student
// columns : rollno name marks gender

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

    
    private static final String dbUrl = "jdbc:mysql://127.0.0.1:3306/college";
    private static final String username = "root";
    private static final String password = "Amey1234";

    public static void main(String[] args) {
        
        // Load the MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection;
        try {
            connection = DriverManager.getConnection(dbUrl, username, password); // Establish a connection to the database
            Statement statement = connection.createStatement(); // Create a statement for executing SQL queries
            String printTable = "SELECT * from student"; // Define the SQL query
            ResultSet resultSet = statement.executeQuery(printTable); // Execute the SQL query

            System.out.println("Roll.\tName\tMarks\tGender");

            while (resultSet.next()) {
                int rollno = resultSet.getInt("rollno");
                String name = resultSet.getString("name");
                int marks = resultSet.getInt("marks");
                String gender = resultSet.getString("gender");
                
                System.out.println(rollno+"\t"+name+"\t"+marks+"\t"+gender);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    
}