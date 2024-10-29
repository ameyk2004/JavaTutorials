package models;
import java.util.ArrayList;

public class User {
    int id;
    String name;
    boolean isAdmin;
    ArrayList<Book> books_issued;


    public User(int id, String name, boolean isAdmin, ArrayList<Book> books_issued) {
        this.id = id;
        this.name = name;
        this.isAdmin = isAdmin;
        this.books_issued  = new ArrayList<Book>();
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsAdmin() {
        return this.isAdmin;
    }

    public boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public ArrayList<Book> getBooks_issued() {
        return this.books_issued;
    }

    public void setBooks_issued(ArrayList<Book> books_issued) {
        this.books_issued = books_issued;
    }

}
