package projects.LibraryManagementSystem;
import java.util.Scanner;

import projects.LibraryManagementSystem.models.User;
import projects.LibraryManagementSystem.services.Library;

public class LibraryManagement {
    Library library;
    Scanner sc;

    LibraryManagement()
    {
        this.library = new Library();
        this.sc = new Scanner(System.in);
    }

    void start()
    {
        System.out.println("Welcome to PL Library");
        int cont = 1;

        do {
            System.out.println("Enter your Details");

            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("User ID : ");

            int id = sc.nextInt();
            sc.nextLine();

            if (name.equalsIgnoreCase("Admin")) {
                System.out.println("You are an admin");
                int choice = 0;

                do {
                    System.out.println("\n\n\nYou can:");
                    System.out.println("1. ADD BOOKS");
                    System.out.println("2. SEE AVAILABLE BOOKS");
                    System.out.println("3. SEE BORROWERD BOOKS");
                    System.out.println("4. LOGOUT");
                    System.out.print("Enter choice: ");
                    choice = sc.nextInt();

                    if (choice == 1) {
                        library.addBook(sc);
                    } 
                    else if (choice == 2) {
                        library.seeAvailableBooks(sc);
                    }
                    else if (choice == 3) {
                        library.seeBorrowedBooks(sc);
                    }
                    else if (choice == 4) {
                        System.out.println("Logged out");
                        break;
                    }
                } while (choice != 4);
            }

            else
            {
                System.out.println("You are a normal User");
                int choice = 0;

                User user = new User(id, name, false, null);

                do {
                    System.out.println("\n\n\nYou can:");
                    System.out.println("1. Borrow Book");
                    System.out.println("2. SEE AVAILABLE BOOKS");
                    System.out.println("3. LOGOUT");
                    System.out.print("Enter choice: ");
                    choice = sc.nextInt();

                    if (choice == 1) {
                        library.borrowBook(sc, user);
                    } 
                    else if (choice == 2) {
                        library.seeAvailableBooks(sc);
                    }
                    else if (choice == 3) {
                        System.out.println("Logged out");
                        break;
                    }
                } while (choice != 3);

            
            }

            System.out.print("Do you want to continue? (0 to exit, 1 to continue): ");
            cont = sc.nextInt();
            sc.nextLine();

        } while (cont != 0);

        sc.close();
        System.out.println("Library Closed.");
    }

    public static void main(String args[])
    {
        LibraryManagement libraryManagement = new LibraryManagement();
        libraryManagement.start();
    }
}

