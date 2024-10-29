package models;

public class Book{
    int id;
    String name;
    User issued_by;
    boolean isAvailable;

    public Book(int id, String name, User issued_by, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.issued_by = issued_by;
        this.isAvailable = isAvailable;
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

    public User getIssued_by() {
        return this.issued_by;
    }

    public void setIssued_by(User issued_by) {
        this.issued_by = issued_by;
    }

    public boolean isIsAvailable() {
        return this.isAvailable;
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", issued_by='" + getIssued_by() + "'" +
            ", isAvailable='" + isIsAvailable() + "'" +
            "}";
    }

}