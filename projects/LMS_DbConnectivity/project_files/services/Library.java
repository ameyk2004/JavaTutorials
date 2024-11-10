package projects.LMS_DbConnectivity.project_files.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import projects.LMS_DbConnectivity.project_files.models.Book;
import projects.LMS_DbConnectivity.project_files.models.User;

public class Library {
    ArrayList<Book> availableBooks = new ArrayList<>();
    User user;

    Database db;
    Scanner sc;

    public Library() {
        System.err.println("Library Started");
        this.db = new Database();
        this.sc = new Scanner(System.in);
    }

    public void login() {
        System.out.println("\n--------------------------------------");
        System.out.println("LOGIN DASHBOARD");

        System.out.print("Enter email : ");
        String email = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        this.user = db.login(email, password);

        if (this.user != null) {
            System.out.println("Welcome " + user.getName() + ",");

            if ((user.getRole()).equals("admin")) {
                int choice;
                do {
                    System.out.println("\n\nYou can:");
                    System.out.println("1. ADD BOOKS");
                    System.out.println("2. SEE AVAILABLE BOOKS");
                    System.out.println("3. SEE BORROWED BOOKS BY EACH USER");
                    System.out.println("4. CHECK FINE BY EACH USER");
                    System.out.println("5. LOGOUT");
                    System.out.print("Enter choice: ");
                    choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1 -> addBook();
                        case 2 -> seeAvailableBooks();
                        case 3 -> seeBorrowedBooksForAdmin();
                        case 4 -> checkFinePerUser();
                        case 5 -> System.out.println("Logged out");
                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                } while (choice != 4);
            } else {
                int choice;
                do {
                    System.out.println("\n\nYou can:");
                    System.out.println("1. Borrow Book");
                    System.out.println("2. SEE AVAILABLE BOOKS");
                    System.out.println("3. SEE BORROWED BOOKS BY YOU");
                    System.out.println("4. RETURN BOOK");
                    System.out.println("5. CHECK FINE");
                    System.out.println("6. LOGOUT");
                    System.out.print("Enter choice: ");
                    choice = sc.nextInt();
                    sc.nextLine(); 

                    switch (choice) {
                        case 1 -> borrowBook();
                        case 2 -> seeAvailableBooks();
                        case 3 -> seeBorrowedBooksbyUser();
                        case 4 -> returnBook();
                        case 5 -> checkFine();
                        case 6 -> System.out.println("Logged out");
                        default -> System.out.println("Invalid choice. Please try again.");
                        
                        
                    }
                } while (choice != 6);
            }
        }
    }

    private void checkFinePerUser() {
		db.getTotalFinePerUser();
	}

	private void checkFine() {
		db.generateFineBillUser(user);
	}

	private void returnBook() {
		availableBooks = db.usersBorrowedBooks(this.user);
    	
    	System.out.println("\n--------------------------------------");
        System.out.println("Return Book DASHBOARD");

        System.out.print("\nEnter title of Book : ");
        String nameofBook = sc.nextLine();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        System.out.print("\nEnter date of return (yyyy-MM-dd): ");
        String returnDateInput = sc.nextLine(); 
        LocalDate returnDate = LocalDate.parse(returnDateInput, formatter);
     

        for(Book book : availableBooks) {
        	
        	if((book.getTitle()).equals(nameofBook)) {
        		db.returnbook(user, book, returnDate);
        	
        	}
        }
        
	}

	private void seeBorrowedBooksForAdmin() {
    	
    	System.out.println("\n-------------------------------------------");
		System.out.println("Borrowed Books by Each User");
		System.out.println("-------------------------------------------");
		
		Map<String, List<String>> booksPerUser = db.getBooksPerUser();
		
		for (Map.Entry<String, List<String> > entry : booksPerUser.entrySet()) {
			
	        System.out.println("User : "+entry.getKey());
	        
	        for(String book_name : entry.getValue()) {
	        	System.out.println(book_name);
	        }
	        System.out.println();
	    }
		
		System.out.println("-------------------------------------------\n");
		
		
	}

	public void register() {
        System.out.println("\n--------------------------------------");
        System.out.println("REGISTER DASHBOARD");

        System.out.print("\nEnter name : ");
        String name = sc.nextLine();

        System.out.print("Enter email : ");
        String email = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        db.registerUser(name, email, password);
    }

    public void addBook() {
        System.out.print("Enter title : ");
        String title = sc.nextLine();

        System.out.print("Enter author : ");
        String author = sc.nextLine();

        System.out.print("Enter qty : ");
        int qty = sc.nextInt();
        sc.nextLine(); 

        db.addBook(title, author, qty, qty);
    }

    public void seeAvailableBooks() {
    	
    	availableBooks = db.seeAvailableBooks(this.user);
    	
    	System.out.println("\n-------------------------------------------");
		System.out.println("Available Books");
		System.out.println("-------------------------------------------");
    	
    	for(Book book : availableBooks) {
        	
    		System.out.println("\n-------------------------------------------");
			System.out.println("Title : "+book.getTitle());
			System.out.println("Author : "+book.getAuthor());
			System.out.println("Available Qty : "+book.getAvailableQuantity());
        }
    	
    	System.out.println("-------------------------------------------\n");
    }

    public void seeBorrowedBooksbyUser() {
      ArrayList<Book> borrowedBooks = db.usersBorrowedBooks(user);
       
       for(Book borrowedbook : borrowedBooks) {
       	
   		System.out.println("\n-------------------------------------------");
			System.out.println("Title : "+borrowedbook.getTitle());
			System.out.println("Author : "+borrowedbook.getAuthor());
       
       }
       
		System.out.println("-------------------------------------------\n");
    }

    public void borrowBook() {
    	
    	availableBooks = db.seeAvailableBooks(this.user);
    	
    	System.out.println("\n--------------------------------------");
        System.out.println("Borrow DASHBOARD");

        System.out.print("\nEnter title of Book : ");
        String nameofBook = sc.nextLine();

        for(Book book : availableBooks) {
        	
        	if((book.getTitle()).equals(nameofBook)) {
        		db.borrowBook(this.user, book);
        	
        	}
        }
        
    }
    
    
}
