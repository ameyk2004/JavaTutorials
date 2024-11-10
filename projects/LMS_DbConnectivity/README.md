
# Library Management System with MySQL Database Connectivity

## Table of Contents
1. [Project Overview](#project-overview)
2. [Architecture](#architecture)
3. [Technologies Used](#technologies-used)
4. [Database Setup](#database-setup)
5. [SQL Queries and Triggers](#sql-queries-and-triggers)
   - [DDL Queries](#ddl-queries)
   - [Triggers](#triggers)
   - [Aggregate Queries](#aggregate-queries)
6. [Conclusion](#conclusion)

## Project Overview

The **Library Management System** (LMS) is designed to manage book borrowing, returns, fines, and user roles (admin and borrower). The system integrates with a **MySQL** database for storing and managing data related to users, books, and borrowing transactions. The system allows borrowers to borrow books, return them, and pay fines for late returns. Admin users can manage books and users.

## Library Management System Functions

### Admin Functions

Admin has the following functionalities:
1. **Add Book**: Add new books to the library.
2. **See Available Books**: View all available books in the library.
3. **See Borrowed Books for Each User**: View which books are borrowed by each user.
4. **Check Fine Per User**: View fines for each user.

### User Functions

Users can perform the following actions:
1. **Borrow Book**: Borrow a book from the library.
2. **See Available Books**: View all available books.
3. **See Borrowed Books by You**: View the books borrowed by the user.
4. **Return Book**: Return a borrowed book.
5. **Check Fine**: View the fine due for the user.

## Architecture

The system follows the **Model-View-Controller (MVC)** architecture:
- **Model**: Represents the data, including `User`, `Book`, and `BorrowingTransaction`.
- **View**: Console-based interface for user interaction.
- **Controller**: The Library class, which manages database interactions and user commands.

## Technologies Used

- **Java** for application development.
- **MySQL** for database management.
- **JDBC** for database connectivity.

## Database Setup

### Create Database

```sql
CREATE DATABASE library_management;
```

### DDL Queries

```sql
-- Create Users Table
CREATE TABLE Users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('borrower', 'admin') NOT NULL,
    fine DECIMAL(10, 2) DEFAULT 0.00,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create Books Table
CREATE TABLE Books (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    quantity INT DEFAULT 1,
    available_quantity INT DEFAULT 1,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

-- Create BorrowingTransactions Table
CREATE TABLE BorrowingTransactions (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    book_id INT,
    issue_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    due_date DATE,
    return_date DATE,
    fine DECIMAL(10, 2) DEFAULT 0.00,
    status ENUM('borrowed', 'returned') NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(id),
    FOREIGN KEY (book_id) REFERENCES Books(id)
);
```

### Triggers

```sql
-- Trigger to update the available quantity when a book is borrowed
DELIMITER $$

CREATE TRIGGER update_available_quantity_before_borrow
BEFORE INSERT ON BorrowingTransactions
FOR EACH ROW
BEGIN
    UPDATE Books 
    SET available_quantity = available_quantity - 1
    WHERE id = NEW.book_id;
END $$

-- Trigger to restore available quantity when a book is returned
CREATE TRIGGER update_available_quantity_after_return
AFTER UPDATE ON BorrowingTransactions
FOR EACH ROW
BEGIN
    IF OLD.return_date IS NULL AND NEW.return_date IS NOT NULL THEN
        UPDATE Books 
        SET available_quantity = available_quantity + 1
        WHERE id = OLD.book_id;
    END IF;
END $$

DELIMITER ;
```

### Aggregate Queries

1. **Total Number of Books Borrowed by Each User**:

```sql
SELECT u.name, COUNT(bt.book_id) AS total_books_borrowed
FROM Users u
JOIN BorrowingTransactions bt ON u.id = bt.user_id
GROUP BY u.id;
```

2. **Total Fine per User**:

```sql
SELECT u.name, SUM(DATEDIFF(CURRENT_DATE, bt.return_date) * 5) AS total_fine
FROM Users u
JOIN BorrowingTransactions bt ON u.id = bt.user_id
WHERE bt.return_date < CURRENT_DATE
GROUP BY u.id;
```

3. **Books with the Most Borrowed Count**:

```sql
SELECT b.title, COUNT(bt.book_id) AS borrow_count
FROM Books b
JOIN BorrowingTransactions bt ON b.id = bt.book_id
GROUP BY b.id
ORDER BY borrow_count DESC
LIMIT 10;
```

4. **Total Available Books in the Library**:

```sql
SELECT SUM(available_quantity) AS total_available_books
FROM Books;
```

## Conclusion

The **Library Management System with MySQL Database Connectivity** provides a comprehensive solution for managing books, users, and transactions. It includes:
- Book borrowing and returning functionality.
- Administrative capabilities to manage books and users.
- Fine calculation and tracking.
- Efficient SQL queries and triggers for handling real-time data updates and aggregate functions.

Feel free to explore and modify the project to fit your needs. For any questions, please contact the project maintainer at `your-email@example.com`.
