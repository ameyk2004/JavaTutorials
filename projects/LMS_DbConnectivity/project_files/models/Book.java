package projects.LMS_DbConnectivity.project_files.models;


public class Book {
    private int id;
    private String title;
    private String author;
    private int quantity;
    private int availableQuantity;
    
    public Book(int id, String title, String author,int avl_qty) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.availableQuantity = avl_qty;
    }
    
    public Book(int id, String title, String author,int qty, int avl_qty) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.availableQuantity = qty;
        this.availableQuantity = avl_qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    // Optional: Override toString() for better representation
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author
                + ", quantity=" + quantity + ", availableQuantity=" + availableQuantity;
    }
}
