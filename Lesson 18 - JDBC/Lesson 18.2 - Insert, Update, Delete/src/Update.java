import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    private static final String dbUrl = "jdbc:mysql://127.0.0.1:3306/college";
    private static final String username = "root";
    private static final String password = "Amey1234";
    public static void main(String[] args) {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {

            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student SET marks = ? WHERE name = ?");

            preparedStatement.setInt(1, 55);
            preparedStatement.setString(2, "Amey Kulkarni");

            int affectedRow = preparedStatement.executeUpdate();

            if(affectedRow > 0)
            {
                System.out.println("Updated marks");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        

    }
}
