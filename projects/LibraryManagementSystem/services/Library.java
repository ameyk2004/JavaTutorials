package services;
import java.util.ArrayList;
import java.util.Scanner;

import models.Book;
import models.User;

public class Library {
    ArrayList<Book> booksInLibrary;
    ArrayList<User> usersInLibrary;


    public Library() {
        booksInLibrary = new ArrayList<>();
        System.err.println("Library Started");
    }

    public void addBook(Scanner sc) {
        System.out.println("\n\n------------------");
        System.out.println("Enter Book id: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume the newline
        System.out.println("Enter Book name: ");
        String name = sc.nextLine();
        User issued_by = null;
        boolean isAvailable = true;

        Book newBook = new Book(id, name, issued_by, isAvailable);
        this.booksInLibrary.add(newBook);

        System.out.println("New Book Added");
        System.err.println(booksInLibrary);
    }


    public void seeAvailableBooks(Scanner sc) {
        System.out.println("\n\n------------------");
        System.out.println("Available Books");

        if(booksInLibrary.isEmpty())
        {
            System.out.println("NO BOOKS IN LIBRARY");
        }

        else{

            for(Book book : booksInLibrary)
            {
                if(book.getIsAvailable())
                {
                    System.out.println(book.getName());
                }
            }
    }
    }

    public void seeBorrowedBooks(Scanner sc) {
        System.out.println("\n\n------------------");
        System.out.println("Borrowed Books");
        for(Book book : booksInLibrary)
        {
            if(!book.getIsAvailable())
            {
                System.out.println("\n"+book);
                System.out.println("Borrowed by : " + book.getIssued_by().getName());
            }
        }
    }

    public void borrowBook(Scanner sc, User user) {
        System.out.println("\n\n------------------");
        System.out.println("Borrow Book Interface");

        System.out.println("Enter Book id: ");
        int id = sc.nextInt();


        for(Book book : booksInLibrary)
        {
            if(book.getId() == id)
            {
               if(book.getIsAvailable())
               {
                book.setIsAvailable(false);
                book.setIssued_by(user);
                System.out.println("Book Borrowed");
               }
            }
        }


        for(Book book : booksInLibrary)
        {
            if(!book.getIsAvailable())
            {
                System.out.println("\n"+book.getName());
                System.out.println("Borrowed by : " + book.getIssued_by().getName());
            }
        }
    }
       
}