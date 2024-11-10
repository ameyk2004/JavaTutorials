package projects.LMS_DbConnectivity.project_files.main;

import java.util.Scanner;

import projects.LMS_DbConnectivity.project_files.models.User;

import projects.LMS_DbConnectivity.project_files.services.Library;

public class LibraryManagement {
    Library library;
    Scanner sc;

    LibraryManagement()
    {
        this.library = new Library();
        this.sc = new Scanner(System.in);
    }
    
    
    void features(User user)
    {
    	
    }

    void start()
    {
    	System.out.println("\n*************************************************");
        System.out.println("\t\tWelcome to PL Library");
        System.out.println("*************************************************");
        int cont = 1;

        do {
        	System.out.println("\n--------------------------------------");
            System.out.println("1. LOGIN");
            System.out.println("2. REGISTER");
            System.out.print("Enter choice: ");
            
            int ch = sc.nextInt();
         
            sc.nextLine();
            
            
            if(ch == 1)
            {
            	library.login();
            }
            
            else if(ch == 2)
            {
            	library.register();
            }
            
            

            
            else
            {
                System.out.println("You are a normal User");
                

            
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

