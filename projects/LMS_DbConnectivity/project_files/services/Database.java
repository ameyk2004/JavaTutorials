package projects.LMS_DbConnectivity.project_files.services;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import projects.LMS_DbConnectivity.project_files.models.Book;
import projects.LMS_DbConnectivity.project_files.models.User;

public class Database {
	Connection conn;
	
	public Database()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			String url = "jdbc:mysql://localhost:3306/LibraryManagementSystem";
			String username = "root";
			String password = "Amey1234";

			this.conn = DriverManager.getConnection(url, username, password);
			
			System.out.println("Database Connected");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public User registerUser(String name, String email, String password) {
        
        String insertSQL = "INSERT INTO Users (name, email, password) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1); 
                    String role = "borrower";
                    BigDecimal fine = new BigDecimal(0.0);
                    Timestamp createdAt = new Timestamp(System.currentTimeMillis());


                    System.out.println("User registered with ID: " + id);

                    User user = new User(id, name, email, password, role, fine, createdAt);
                    return user;
                }
            } else {
                System.out.println("Error: User not registered.");
            }
        } catch (SQLException e) {
        	System.out.println("Error: User not registered.");
        }

        return null; 
    }
	
	
public User login(String email, String pass) {
        
        String loginSQL = "SELECT * FROM Users where email = ?";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(loginSQL);

            preparedStatement.setString(1, email);

     
            ResultSet userData = preparedStatement.executeQuery();
  
            if (!userData.next()) {
                System.out.println("No user found with the provided email.");
            } else {
    
                String password = userData.getString("password");
                
                System.out.println("User found: " + email);
                
                if(pass.equals(password))
                {	
                	String role = userData.getString("role");
                	String name = userData.getString("name");
                	int id = userData.getInt("id");
                    BigDecimal fine = new BigDecimal(0.0);
                    Timestamp createdAt = new Timestamp(System.currentTimeMillis());
                	
                	System.out.println("\n\nLogged in with User id " + id);

                    User user = new User(id, name, email, password, role, fine, createdAt);
                			
                	return user;
                }
            }
        
                
        } catch (SQLException e) {
        	System.out.println("Error: User not registered.");
        }

        return null; 
    }

public Book addBook(String title, String author, int qty, int avl_qty) {
	
	 String insertSQL = "INSERT INTO Books (title, author, quantity, available_quantity) VALUES (?, ?, ?, ?)";

     try {
         PreparedStatement preparedStatement = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);

         preparedStatement.setString(1, title);
         preparedStatement.setString(2, author);
         preparedStatement.setInt(3, qty);
         preparedStatement.setInt(4, avl_qty);

         int rowsAffected = preparedStatement.executeUpdate();

         if (rowsAffected > 0) {
             ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

             if (generatedKeys.next()) {
                 int id = generatedKeys.getInt(1); 
                //  String role = "borrower";
                //  BigDecimal fine = new BigDecimal(0.0);
                //  Timestamp createdAt = new Timestamp(System.currentTimeMillis());


                 System.out.println("Book added with ID: " + id);

                 Book newBook = new Book(id, title, author, qty, avl_qty);
                 
                 System.out.println("\nBook added Successfuly");
                 System.out.println("-------------------------------------------");
                 return newBook;
             }
         } else {
             System.out.println("Error: Book not added");
         }
     } catch (SQLException e) {
    	 System.out.println(e.toString());
     }

     return null; 
}

ArrayList<Book> seeAvailableBooks(User user) {
    String viewBooksSQL = "SELECT * FROM Books "
            + "WHERE available_quantity > 0 "
            + "AND id NOT IN (SELECT book_id FROM BorrowingTransactions WHERE user_id = ?)";

    ArrayList<Book> avlBooks = new ArrayList<>();

    try (PreparedStatement st = conn.prepareStatement(viewBooksSQL)) {
        st.setInt(1, user.getId());
        try (ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                String title = rs.getString("title");
                int id = rs.getInt("id");
                String author = rs.getString("author");
                int avl_qty = rs.getInt("available_quantity");

                Book book = new Book(id, title, author, avl_qty);
                avlBooks.add(book);
            }

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return avlBooks;
}


ArrayList<Book> usersBorrowedBooks(User user)
{
	String query = "SELECT * FROM Books WHERE id IN ("
            + "SELECT book_id FROM BorrowingTransactions WHERE user_id = ? AND status = 'borrowed') ";

	
	ArrayList<Book> borrowedBookByUser = new ArrayList<Book>();
	
	try {
		PreparedStatement st = conn.prepareStatement(query);
		
		st.setInt(1, user.getId());
		
		ResultSet rs = st.executeQuery();
		
		System.out.println("\n-------------------------------------------");
		System.out.println("Books Borrowed by "+user.getName());
		System.out.println("-------------------------------------------");
		
		while(rs.next())
		{
			String title = rs.getString("title");
			int id = rs.getInt("id");
			String author = rs.getString("author");
			int avl_qty = rs.getInt("available_quantity");
			
			Book book = new Book(id, title, author, avl_qty);
			borrowedBookByUser.add(book);
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return borrowedBookByUser;
	
}

public Map<String, List<String>> getBooksByAuthor() {
    String sql = "SELECT author, title FROM Books ORDER BY author";
    Map<String, List<String>> booksByAuthor = new HashMap<>();

    try (PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            String author = rs.getString("author");
            String title = rs.getString("title");   // Get book title

            // Add the book title to the list of books for the author
            booksByAuthor.computeIfAbsent(author, k -> new ArrayList<>()).add(title);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return booksByAuthor;
}


public void borrowBook(User user, Book book) {
    String borrowBookSQL = "INSERT INTO BorrowingTransactions (user_id, book_id, due_date, status) VALUES (?, ?, ?, ?)";
    
    try (PreparedStatement stmt = conn.prepareStatement(borrowBookSQL)) {
   
        stmt.setInt(1, user.getId());
        stmt.setInt(2, book.getId());
        LocalDate dueDate = LocalDate.now().plusDays(2); 
        stmt.setDate(3, Date.valueOf(dueDate));

        stmt.setString(4, "borrowed");
        
        int rowsAffected = stmt.executeUpdate(); 
        if(rowsAffected > 0)
        {
        	System.out.println("\nBorrowing Successful");
        }
        else
        {
        	System.out.println("\nBorrowing Not Succesful"); 
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void returnbook(User user, Book book, LocalDate returnDate) {
    String updateTransactionSQL = "UPDATE BorrowingTransactions SET status = ?, return_date = ?, fine = ? WHERE book_id = ? AND user_id = ?";
    String getDueDateSQL = "SELECT due_date FROM BorrowingTransactions WHERE book_id = ? AND user_id = ?";

    try (PreparedStatement getDueStmt = conn.prepareStatement(getDueDateSQL);
         PreparedStatement updateStmt = conn.prepareStatement(updateTransactionSQL)) {

        getDueStmt.setInt(1, book.getId());
        getDueStmt.setInt(2, user.getId());

        ResultSet rs = getDueStmt.executeQuery();
        if (rs.next()) {
            LocalDate dueDate = rs.getDate("due_date").toLocalDate();
            long overdueDays = ChronoUnit.DAYS.between(dueDate, returnDate);
            double fineAmount = 0.0;

            if (overdueDays > 0) {
                if (overdueDays <= 5) {
                    fineAmount = overdueDays * 1.0;
                } else if (overdueDays > 5 && overdueDays<=20) {
                    fineAmount = (5 * 1.0) + ((overdueDays - 5) * 2.5);
                } else {
                    fineAmount = (5 * 1.0) + (10 * 2.5) + ((overdueDays - 15) * 4.5);
                }
            }

            updateStmt.setString(1, "returned");
            updateStmt.setDate(2, Date.valueOf(returnDate));
            updateStmt.setDouble(3, fineAmount);
            updateStmt.setInt(4, book.getId());
            updateStmt.setInt(5, user.getId());

            int rowsAffected = updateStmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("\nBook Returned Successfully");
            } else {
                System.out.println("\nBook Return Failed");
            }

        } else {
            System.out.println("\nTransaction not found.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public Map<String, List<String>> getBooksPerUser() {
    String query = "SELECT u.name AS user_name, b.title AS book_title "
                 + "FROM Users u "
                 + "JOIN BorrowingTransactions bt ON u.id = bt.user_id "
                 + "JOIN Books b ON bt.book_id = b.id "
                 + "WHERE bt.status = 'borrowed' "
                 + "ORDER BY u.name, b.title";

    Map<String, List<String>> booksPerUser = new HashMap<>();
    
    try (PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {
        
        while (rs.next()) {
            String userName = rs.getString("user_name");
            String bookTitle = rs.getString("book_title");

            if (booksPerUser.containsKey(userName)) {
                booksPerUser.get(userName).add(bookTitle);
            } else {
                List<String> books = new ArrayList<>();
                books.add(bookTitle);
                booksPerUser.put(userName, books);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
   
    
    return booksPerUser;
}

public void generateFineBillUser(User user) {
	String sql1 = "SELECT "
            + "    b.title, "
            + "    COALESCE(bt.fine, 0) as fine, "
            + "    COALESCE(DATEDIFF(bt.return_date, bt.due_date), 0) as overdue_days "
            + "FROM BorrowingTransactions as bt "
            + "JOIN Users as u ON u.id = bt.user_id "
            + "JOIN Books as b ON bt.book_id = b.id "
            + "WHERE u.id = ?;";

    String sql2 = "SELECT u.name, SUM(bt.fine) as total_fine "
                 + "FROM BorrowingTransactions as bt "
                 + "JOIN Users as u ON u.id = bt.user_id "
                 + "GROUP BY u.id "
                 + "HAVING u.id = ?;";
    
    System.out.println("\n\n-----------------------------------------------------------");
    System.out.println("\t\tTOTAL FINE CALCULATION");
    System.out.println("-----------------------------------------------------------");

    try (PreparedStatement stmt = conn.prepareStatement(sql1)) {
        stmt.setInt(1, user.getId());

        try (ResultSet rs = stmt.executeQuery()) {
            System.out.println("\n\n+----------------------------+------------+---------------+");
            System.out.printf("| %-26s | %-10s | %-13s |\n", "Book Title", "Fine", "Overdue Days");
            System.out.println("+----------------------------+------------+---------------+");

            while (rs.next()) {
                String title = rs.getString("title");
                double fine = rs.getDouble("fine");
                double overdue_days = rs.getDouble("overdue_days");

                System.out.printf("| %-26s | %-10.2f | %-13.0f |\n", title, fine, overdue_days);
            }

            System.out.println("+----------------------------+------------+---------------+");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }


    try (PreparedStatement stmt = conn.prepareStatement(sql2)) {
        stmt.setInt(1, user.getId());

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                double totalFine = rs.getDouble("total_fine");
                System.out.println("\n-----------------------------------------------------------");
                System.out.println("\t\tTotal Fine: " + totalFine);
                System.out.println("-----------------------------------------------------------");
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void getTotalFinePerUser() {
    String sql = "SELECT u.name, SUM(bt.fine) AS total_fine "
               + "FROM BorrowingTransactions AS bt "
               + "JOIN Users AS u ON bt.user_id = u.id "
               + "GROUP BY u.name;";

    try (PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        // Print table header
        System.out.println("\n+--------------------+-------------+");
        System.out.printf("| %-18s | %-11s |\n", "User Name", "Total Fine");
        System.out.println("+--------------------+-------------+");

        // Print the result rows
        while (rs.next()) {
            String name = rs.getString("name");
            double totalFine = rs.getDouble("total_fine");
            System.out.printf("| %-18s | %-11.2f |\n", name, totalFine);
        }

        // Print table footer
        System.out.println("+--------------------+-------------+");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}





