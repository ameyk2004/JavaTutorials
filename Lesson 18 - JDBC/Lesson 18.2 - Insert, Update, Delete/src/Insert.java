import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class INSERT{

    private static final String dbUrl = "jdbc:mysql://127.0.0.1:3306/college";
    private static final String username = "root";
    private static final String password = "Amey1234";

    public static void main(String[] args) {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            // Define the SQL query for inserting data into the student table
            String insertQuery = "INSERT INTO student (rollno, name, marks, gender) VALUES(?,?,?,?)";
            Connection connection = DriverManager.getConnection(dbUrl, username, password);

            // Create a prepared statement for executing the insert query
            PreparedStatement statement = connection.prepareStatement(insertQuery);

            // Set parameters for the first student
            statement.setInt(1, 44);  
            statement.setString(2, "Kshitij Markandeya");
            statement.setInt(3, 76);
            statement.setString(4, "M"); 

            // Add the first student data to the batch
            statement.addBatch();

            // Set parameters for the second student
            statement.setInt(1, 38);  
            statement.setString(2, "Parth Kulkarni");
            statement.setInt(3, 72);
            statement.setString(4, "M"); 

            // Add the second student data to the batch
            statement.addBatch();

            // Set parameters for the third student
            statement.setInt(1, 40);  
            statement.setString(2, "Sushrut Lajurkar");
            statement.setInt(3, 55);
            statement.setString(4, "M"); 

            // Add the third student data to the batch
            statement.addBatch();

            // Execute the batch update and get the affected rows count
            int[] affectedRows = statement.executeBatch(); 
            // int affectedRows = statement.executeUpdate(); -> for single update

            for(int affectedRow : affectedRows) {
                if(affectedRow > 0) {
                    System.out.println("Data inserted");
                } else {
                    System.out.println("Data not inserted");
                }
            }
        } catch (SQLException e) {
            // Print error if a SQL exception occurs
            System.out.println(e.getMessage());
        }
    
    }
}
