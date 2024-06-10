# Java JDBC Connection Example

This project demonstrates how to connect to a MySQL database using JDBC in Java.

## Prerequisites

- Java Development Kit (JDK) installed
- MySQL server installed and running
- MySQL JDBC driver (`mysql-connector-j-8.4.0.jar`) downloaded

## Steps to Create A Java Project

1. **Open VS Code Command Pallete**:
 
```sh
 Press Cmd+shift+P
```

2. **Type Create Java Project**:
```sh
 Select No build tools
```
 
2. **Download jar file**:
```sh
 Download the connector file and place it in lib folder
```
## Folder Structure

Ensure your project directory is structured as follows:

<pre>
Lesson 18 - JDBC
├── lib
│ └── mysql-connector-j-8.4.0.jar
├── src
│ └── App.java
</pre>


## Steps to Compile and Run

1. **Navigate to the `src` Directory**:

   Open a terminal and navigate to the `src` directory of your project:

    <pre>
   cd "/Users/ameykulkarni/Documents/Programs/JavaTutorials/Lesson 18 - JDBC/src/"
   </pre>

2. **Compile Your Java Program**:

   Use the -cp option to include the MySQL JDBC driver JAR in the classpath during compilation. Ensure to escape spaces in the path:

    <pre>
   javac -cp .:/Users/ameykulkarni/Documents/Programs/JavaTutorials/Lesson\ 18\ -\ JDBC/lib/mysql-connector-j-8.4.0.jar App.java
   </pre>

   Baically it is :
   <pre>
    javac -cp .:/path_to_jar_file App.java
   </pre>

2. **Run Your Java Program**:

   Again, use the -cp option to include the MySQL JDBC driver JAR in the classpath during execution

    <pre>
   java -cp .:/Users/ameykulkarni/Documents/Programs/JavaTutorials/Lesson\ 18\ -\ JDBC/lib/mysql-connector-j-8.4.0.jar App
   </pre>


**Example Code**


Here's the Java code (App.java) for reference:

```sh
import java.sql.*;

public class App {
   static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/college"; // Specify the database name
   static final String USER = "root";
   static final String PASS = "YourPassword";

   public static void main(String[] args) {
      // Open a connection
      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
         System.out.println("Connection successful");

         // Create a statement
         Statement stmt = conn.createStatement();

         // Execute the query
         String sql = "SELECT * FROM course";
         ResultSet rs = stmt.executeQuery(sql);

         // Process the results
         while (rs.next()) {
            int studId = rs.getInt("stud_id");
            String courseName = rs.getString("course_name");
            System.out.println("Student ID: " + studId + ", Course Name: " + courseName);
         }

         // Close the result set and statement
         rs.close();
         stmt.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
```

