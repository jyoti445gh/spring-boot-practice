# Servlet CRUD Demo

A simple Java Servlet-based web application demonstrating the fundamentals of **Java Servlets, Tomcat, HTTP request/response handling, and layered application structure**.

This project follows the Servlet concepts covered in the accompanying Servlet notes: Tomcat acts as the Servlet Container, receives HTTP requests, creates request/response objects, and calls the appropriate Servlet method.

## Project Structure

```text
ServletCrudDemo/
│
├── .idea/
├── .mvn/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org.example/
│   │   │       ├── model/
│   │   │       │   └── User.java
│   │   │       │
│   │   │       ├── service/
│   │   │       │   └── ...
│   │   │       │
│   │   │       ├── servlet/
│   │   │       │   └── ...
│   │   │       │
│   │   │       └── Main.java
│   │   │
│   │   └── resources/
│   │
│   └── test/
│
├── target/
├── .gitignore
└── pom.xml
```

### Package Responsibilities

| Package | Responsibility |
|---|---|
| `model` | Contains Java model/entity classes such as `User` |
| `service` | Contains application/business logic |
| `servlet` | Handles HTTP requests and responses |
| `resources` | Contains application resources/configuration |
| `test` | Contains test code |

## Technologies Used

- Java
- Java Servlets
- Apache Tomcat 10
- Maven
- HTTP
- IntelliJ IDEA

## How Servlet Request Handling Works

The browser does not directly call a Java class or method.

The basic request flow is:

```text
Browser
   ↓
HTTP Request
   ↓
Tomcat
   ↓
Servlet Container
   ↓
Matching Servlet
   ↓
doGet() / doPost() / doPut() / doDelete()
   ↓
HTTP Response
   ↓
Browser
```

Tomcat is responsible for listening on the configured port and managing Servlet objects.

For example:

```text
http://localhost:8080/hello
```

means:

- `localhost` → current machine
- `8080` → port where Tomcat is listening
- `/hello` → requested path

## Servlet Lifecycle

Tomcat manages the Servlet lifecycle.

```text
Servlet Object Creation
        ↓
      init()
        ↓
     service()
        ↓
doGet()/doPost()/doPut()/doDelete()
        ↓
     destroy()
```

### `init()`

Called when the Servlet is initialized. It can be used for one-time setup work.

### `service()`

Called for each request. `HttpServlet` uses the HTTP method to route the request to the appropriate method.

### HTTP Methods

| Method | Typical Purpose |
|---|---|
| `GET` | Read/fetch data |
| `POST` | Create data |
| `PUT` | Update data |
| `DELETE` | Delete data |

### `destroy()`

Called when the Servlet is removed from service, such as when Tomcat stops or the application is undeployed.

## Tomcat

Tomcat is a **Servlet Container**.

It manages:

- Servlet object creation
- Servlet lifecycle
- Request and response objects
- URL mapping
- HTTP request handling
- Thread management
- Sending responses back to the client

The Servlet itself does **not** directly listen on port `8080`.

The correct mental model is:

```text
Tomcat listens on port 8080
        ↓
Tomcat receives HTTP request
        ↓
Tomcat finds the matching Servlet
        ↓
Tomcat calls the Servlet
        ↓
Servlet prepares response
        ↓
Tomcat sends response to browser
```

## Requirements

Install the following before running the project:

1. JDK
2. Maven
3. Apache Tomcat 10
4. IntelliJ IDEA (recommended)

## Maven Build

Open a terminal in the project directory and run:

```bash
mvn clean package
```

This compiles the application and creates the build output inside the `target` directory.

## Running with External Tomcat

For a traditional Servlet application, the application can be packaged as a WAR file and deployed to Tomcat.

General flow:

```text
Java Servlet Project
       ↓
mvn clean package
       ↓
WAR file
       ↓
Tomcat/webapps
       ↓
Start Tomcat
       ↓
Application runs
```

Copy the generated WAR file from:

```text
target/
```

to:

```text
apache-tomcat-10.x/webapps/
```

Then start Tomcat.

### Windows

From the Tomcat directory:

```bat
bin\catalina.bat run
```

Or start it in the background:

```bat
bin\startup.bat
```

Stop it with:

```bat
bin\shutdown.bat
```

### macOS / Linux

Run Tomcat in the foreground:

```bash
./bin/catalina.sh run
```

Start in the background:

```bash
./bin/startup.sh
```

Stop Tomcat:

```bash
./bin/shutdown.sh
```

## Check Tomcat

After starting Tomcat, open:

```text
http://localhost:8080
```

If Tomcat is running correctly, its welcome page should be displayed.

After deploying the application, use the application's configured context path and Servlet mappings to access its endpoints.

## Port 8080 Already in Use

### Windows

Check which process is using port `8080`:

```bat
netstat -ano | findstr :8080
```

Then stop the process:

```bat
taskkill /PID PROCESS_ID /F
```

Replace `PROCESS_ID` with the PID returned by the previous command.

### macOS / Linux

Check the port:

```bash
lsof -i :8080
```

Stop the process:

```bash
kill -9 PROCESS_ID
```

## Servlet Dependency

Servlet API classes such as:

```java
HttpServlet
HttpServletRequest
HttpServletResponse
```

are required while compiling the application.

When using an external Tomcat server, Tomcat provides these classes at runtime. Therefore, the Servlet API dependency is normally configured with Maven scope:

```xml
<scope>provided</scope>
```

This means:

```text
Compile time → Maven provides Servlet API
Runtime      → Tomcat provides Servlet API
```

The Servlet API should not unnecessarily be packaged again inside the application WAR when Tomcat already provides it.

## Traditional Servlet vs Spring MVC

This project helps build the foundation for understanding Spring MVC.

### Traditional Servlet

```text
Browser
   ↓
Tomcat
   ↓
UserServlet
   ↓
Business Logic
   ↓
Response
```

### Spring MVC

```text
Browser / Postman
       ↓
     Tomcat
       ↓
 DispatcherServlet
       ↓
   Controller
       ↓
    Service
       ↓
    Response
```

Spring MVC still uses the Servlet foundation. Instead of manually creating many Servlets, Spring MVC uses a central `DispatcherServlet` to route requests to controller methods.

## Important Concepts Learned

- HTTP request and response
- Client and server
- Servlet
- Servlet Container
- Apache Tomcat
- URL mapping
- `HttpServletRequest`
- `HttpServletResponse`
- Servlet lifecycle
- `init()`
- `service()`
- `doGet()`
- `doPost()`
- `doPut()`
- `doDelete()`
- `destroy()`
- External Tomcat
- WAR deployment
- Maven `provided` dependency
- Query parameters
- Servlet-to-Spring MVC relationship
- `DispatcherServlet`

## Key Mental Model

Remember:

```text
Browser speaks HTTP
        ↓
Tomcat receives HTTP
        ↓
Tomcat converts request into Java-friendly objects
        ↓
Tomcat calls Servlet
        ↓
Servlet executes application logic
        ↓
Tomcat sends HTTP response
        ↓
Browser receives response
```

**Tomcat listens.  
Servlet handles the request.  
Browser sends and receives HTTP.**

## Author

**Jyoti Nehara**

## License

This project is intended for learning and educational purposes.
