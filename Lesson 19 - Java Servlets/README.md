# Project - SETUP

## Prerequisites

Before you begin, ensure you have met the following requirements:

1. **Java Development Kit (JDK)**: Install JDK 8 or higher.
2. **Eclipse IDE**: Download and install Eclipse IDE for Java EE Developers.
3. **Apache Tomcat**: Download and configure Apache Tomcat 9.x or higher in Eclipse.

## Project Creation Steps

1. **Open Eclipse IDE**.
2. **Create a New Dynamic Web Project**:
   - Go to `File` > `New` > `Dynamic Web Project`.
   - Enter the Project Name (e.g., `MyWebApp`).
   - Click `Next`.

3. **Configure the Web Module**:
   - Leave the default values or adjust as needed.
   - Click `Next`.

4. **Generate Deployment Descriptor**:
   - Ensure `Generate web.xml deployment descriptor` is checked.
   - Click `Finish`.

5. **Create a Servlet**:
   - Right-click on `Java Resources` > `src` folder.
   - Select `New` > `Servlet`.
   - Enter the `Class Name` (e.g., `MyServlet`).
   - Specify the package name (e.g., `com.myapp`).
   - Click `Next`.

6. **Configure the Servlet Mapping**:
   - Map the servlet to a URL pattern (e.g., `/hello`).
   - Click `Finish`.

7. **Implement the Servlet**:
   - Open the `MyServlet.java` file.
   - Implement the `doGet` or `doPost` method. Example:
     ```java
     package com.myapp;

     import java.io.IOException;
     import javax.servlet.ServletException;
     import javax.servlet.annotation.WebServlet;
     import javax.servlet.http.HttpServlet;
     import javax.servlet.http.HttpServletRequest;
     import javax.servlet.http.HttpServletResponse;

     @WebServlet("/hello")
     public class MyServlet extends HttpServlet {
         private static final long serialVersionUID = 1L;

         protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             response.setContentType("text/html");
             response.getWriter().println("<h1>Hello, World!</h1>");
         }
     }
     ```

## Steps to Run the Project

1. **Add Project to Server**:
   - Right-click on the project in the `Project Explorer`.
   - Select `Run As` > `Run on Server`.
   - Choose the configured Tomcat server.
   - Click `Finish`.

2. **Access the Application**:
   - Open a web browser.
   - Navigate to `http://localhost:8080/MyWebApp/hello` (assuming default Tomcat port and context path).

## Optional: Verify Deployment Descriptor

If you need to manually check or edit the deployment descriptor:

1. **Open `web.xml`** in the `WEB-INF` directory.
2. **Ensure the servlet and mapping are correctly defined**:
   ```xml
   <web-app xmlns="http://java.sun.com/xml/ns/javaee"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
                                http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
            version="3.0">
       <servlet>
           <servlet-name>MyServlet</servlet-name>
           <servlet-class>com.myapp.MyServlet</servlet-class>
       </servlet>
       <servlet-mapping>
           <servlet-name>MyServlet</servlet-name>
           <url-pattern>/hello</url-pattern>
       </servlet-mapping>
   </web-app>
```

