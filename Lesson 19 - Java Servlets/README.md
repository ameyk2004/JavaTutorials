# Contents

<a href="#setup"><li>Project - Setup</li></a>

<a href="#simple-servlet-prgram"><li>Simple Servlet Program</li></a>

<a href="#servlet-from-servlet"><li>Calling Servlet from Servlet</li></a>

<a href="#sendRedirect"><li>sendRedirect in Java Servlets</li></a>


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

<hr>
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

<hr>
<h1 id="servlet-from-servlet">Calling Servlet From Servlet</h1>

In Java a Servlet can be called from another Servlet with the help of Request Dispacther.

The RequestDispatcher interface provides a mechanism to forward a request from one servlet to another resource, such as another servlet, JSP page, or HTML file, on the server. This is useful for modularizing the processing logic of web applications and for creating reusable components.

Main Methods
The RequestDispatcher interface defines two main methods:

forward(HttpServletRequest request, HttpServletResponse response)
include(HttpServletRequest request, HttpServletResponse response)

To get Servlet
```java
RequestDispatcher dispatcher = request.getRequestDispatcher("/path");
dispacther.forward(request, response);
```

To transfer results generated in one servlet to another we can add `set attribute` in request;
```java
request.setAttribute('result', result);
```

To fetch this in another servlet
```java
request.getAtrribute('result');
```

Let Us see below `Example` where Aim is to first calculate the Addition of two numbers received from above form.
Then call squate servlet to display square of two numbers.

<h2>AddServlet.java</h2>

```java
    package com.ameyTech;

    import java.io.IOException;

    import javax.servlet.RequestDispatcher;
    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;

    public class AddServlet extends HttpServlet {
        
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            // Extracting the values of 'num1' and 'num2' parameters from the request
            int num1 = Integer.parseInt(request.getParameter("num1"));
            int num2 = Integer.parseInt(request.getParameter("num2"));
            
            // Performing addition operation
            int result = num1 + num2;
            
            request.setAttribute("result", result); // forwards attribute to other servlet
            
            RequestDispatcher rd = request.getRequestDispatcher("sq");
            rd.forward(request, response);
            
        }
    }
```

<h2>SqServlet.java</h2>

```java
    package com.ameyTech;

    import java.io.IOException;
    import java.io.PrintWriter;

    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;

    public class SqServlet extends HttpServlet {
        
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
        {
            PrintWriter out = response.getWriter();
            
            int result = (int) request.getAttribute("result");
            
            result *= result;
            
            out.println("Result of Square = "+ result);
        }

    }
```

DO NOT FORGET TO ADD SERVLET IN `web.xml` file as it is `Deployment Descriptor`

<hr>
<h1 id="sendRedirect">sendRedirect in Java Servlets</h1>

The `sendRedirect` method is part of the `HttpServletResponse interface`. It is used to redirect the client's request to a different URL. This URL can be within the same server or on a different server. 


When a servlet calls sendRedirect, the web server sends an HTTP response to the client with status code 302 (Found) along with the new URL. The client's browser then makes a new request to this URL.

`(In total 2 requests are made by client)`

### How It Works

`Client-Side Redirect` : Unlike RequestDispatcher.forward(), which performs a server-side forward, sendRedirect results in a client-side redirect. The client’s browser is instructed to navigate to a new URL.


`HTTP Status Code` : The server sends an HTTP status code 302 (Found) to the client along with the new URL in the Location header.

`New Request`: The client’s browser makes a new request to the specified URL, losing all request data (parameters, attributes) from the original request.

### Example

```java
public class AddServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Extracting the values of 'num1' and 'num2' parameters from the request
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        
        // Performing addition operation
        int result = num1 + num2;
        
        //Here as you can see parameter is passed allong with query string
        //The Sq Servlet will fetch result in doGet method by .getParameter
        response.sendRedirect("sq?result="+result);
    }
}
```

#### SqServlet class

```java
public class SqServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		PrintWriter out = response.getWriter();
		
		int result = Integer.parseInt(request.getParameter("result")); // getParameter used to fetch data
		
		result *= result;
		
		out.println("Result of Square = "+ result);
	}

}
```