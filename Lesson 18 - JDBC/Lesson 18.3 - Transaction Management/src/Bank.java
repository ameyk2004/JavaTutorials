import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Bank {

    private static final String dbUrl = "jdbc:mysql://127.0.0.1:3306/bank";
    private static final String username = "root";
    private static final String password = "Amey1234";

    void printTable(Connection connection) throws SQLException {
        PreparedStatement printTable = connection.prepareStatement("SELECT * FROM accDetails");
        ResultSet resultSet = printTable.executeQuery();

        System.out.println();
        while (resultSet.next()) {
            int accNum = resultSet.getInt("accNum");
            String name = resultSet.getString("name");
            double balance = resultSet.getDouble("balance");

            System.out.println(accNum + "\t" + name + "\t" + balance);
        }
        System.out.println();
    }

    boolean createAccount(Connection connection, Scanner sc) throws SQLException {
        System.out.print("Enter your Account Number : ");
        int accNumber = sc.nextInt();
        System.out.print("Enter your Name : ");
        String n = sc.next();

        PreparedStatement createAccount = connection.prepareStatement("INSERT INTO accDetails (accNum, name) VALUES(?,?)");
        createAccount.setInt(1, accNumber);
        createAccount.setString(2, n);

        int affect = createAccount.executeUpdate();

        return affect > 0;
    }

    void transfer(Connection connection, Scanner sc) throws SQLException {
        PreparedStatement debitStatement = connection.prepareStatement("UPDATE accDetails SET balance = balance - ? WHERE accNum = ?");
        PreparedStatement creditStatement = connection.prepareStatement("UPDATE accDetails SET balance = balance + ? WHERE accNum = ?");

        System.out.print("Enter your Account Number : ");
        int currAccNumber = sc.nextInt();
        System.out.print("Enter receiver Account Number : ");
        int receiverAccNumber = sc.nextInt();
        System.out.print("Enter Amount : ");
        int amount = sc.nextInt();

        debitStatement.setInt(1, amount);
        debitStatement.setInt(2, currAccNumber);

        creditStatement.setInt(1, amount);
        creditStatement.setInt(2, receiverAccNumber);

        debitStatement.executeUpdate();
        creditStatement.executeUpdate();

        if(isSufficient(connection, amount, currAccNumber))
        {
            connection.commit();
            System.out.println("Transfer Success");
        }
        else
        {
            connection.rollback();
            System.out.println("Transfer Fail");
        }
    }

    boolean isSufficient(Connection connection, int amt, int accNum) throws SQLException
    {
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT balance FROM accDetails WHERE accNum = "+accNum);

        while (resultSet.next()) {
            double balance = resultSet.getInt("balance");

            // System.out.println("\nBalance : "+balance);

            if(balance > 0)
                return true;

        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Use a single Scanner instance
        Bank bank = new Bank();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, username, password);
            connection.setAutoCommit(false);


            String menu = "1. Add Account";
            menu += "\n2. Transfer Money";
            menu += "\n3. Display Info";
            menu += "\n4. Exit";

            int choice = 0;
            do {
                System.out.println(menu);
                System.out.print("\nEnter choice : ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        boolean res = bank.createAccount(connection, sc);
                        if (res)
                            System.out.println("Created Account Successfully");
                        else
                            System.out.println("Error");
                        break;

                    case 2:
                        bank.transfer(connection, sc);
                        break;

                    case 3:
                        bank.printTable(connection);
                        break;

                    default:
                        break;
                }
            } while (choice != 4);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sc.close();
        }
    }
}
