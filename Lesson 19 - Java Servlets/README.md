# Contents

<a href="#setup"><li>Project - Setup</li></a>

<a href="#simple-servlet-prgram"><li>Simple Servlet Program</li></a>


<h1 id="setup">Project - Setup </h1>

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


<h1 id="simple-servlet-prgram">Simple Servlet Program</h1>

In this example we are buiding a simple HTML page which is a form which takes two numbers input frm users adds them and then displays it on`\add` route.

## Steps to Create Files

1. **Create Simple Html File in /src**:
   - Right-click on the project in the `Project Explorer`.
   - Select `Create new Html File`.

2. **Add New Servlet**:
   - Right-click on the project in the `Project Explorer`.
   - Select `Create new Class File`.
   - Enter package name `eg. com.ameyTech`
   - Once Class file is created extend it with HttpServlet class
   - Here is example Code 

   ```java
    package com.ameyTech;

    import java.io.IOException;

    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest; 
    import javax.servlet.http.HttpServletResponse; 

    // Defines a public class AddServlet that extends HttpServlet, which provides the framework for handling HTTP requests and responses
    public class AddServlet extends HttpServlet {
        
        // Overrides the service method of HttpServlet to handle HTTP requests
        public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
            // Retrieves the value of the "num1" parameter from the request, parses it as an integer, and assigns it to num1
            int num1 = Integer.parseInt(request.getParameter("num1"));
            int num2 = Integer.parseInt(request.getParameter("num2"));
            
            int result = num1 + num2;
            
            // Writes the result of the addition to the HTTP response
            response.getWriter().println("Result of " + num1 + " + " + num2 + " = " + result);
        }
    }
   ```

   3. **Configure the Servlet Mapping**:
   - Map the servlet to a URL pattern (e.g., `/add`).
   - Click `Finish`.

   ```xml
    <?xml version="1.0" encoding="UTF-8"?>
        <web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" id="WebApp_ID" version="4.0">
        <display-name>Lesson 19.1 - Simple Servlet</display-name>
        <servlet>
                <servlet-name>AddServlet</servlet-name>
                <servlet-class>com.ameyTech.AddServlet</servlet-class>
        </servlet>
        <servlet-mapping>
                <servlet-name>AddServlet</servlet-name>
                <url-pattern>/add</url-pattern>
        </servlet-mapping>
        </web-app>
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

