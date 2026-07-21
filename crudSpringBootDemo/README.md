# CRUD Spring Boot Demo

Simple Spring Boot application demonstrating a RESTful student CRUD service backed by Spring Data JPA and MySQL.

## Project structure

- `src/main/java/in/strikes/crudSpringBootDemo`
  - `CrudSpringBootDemoApplication.java` - Spring Boot entry point
  - `controller/StudentController.java` - REST endpoints
  - `service/StudentService.java` - business logic
  - `repository/StudentRepository.java` - Spring Data JPA repository
  - `entity/Student.java` - JPA entity model
- `src/main/resources/application.properties` - database and JPA config
- `pom.xml` - Maven build configuration

## Prerequisites

- Java JDK 21+ installed
- MySQL server running locally
- Database named `crud_db`
- MySQL user credentials matching `application.properties`

## Configuration

The application reads database settings from `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/crud_db
spring.datasource.username=root
spring.datasource.password=jyoti
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

If your MySQL server uses a different port, database name, or credentials, update the file accordingly.

## Run the application

From the project root:

```powershell
.\mvnw clean package
.\mvnw spring-boot:run
```

The app will start on `http://localhost:8080`.

## REST API Endpoints

Base path: `/api/students`

### Create student

- `POST /api/students/create`
- Request body example:

```json
{
  "id": 1,
  "name": "John Doe",
  "age": 20,
  "email": "john.doe@example.com",
  "rollNo": 101,
  "subject": "Mathematics"
}
```

### Read student by query parameter

- `GET /api/students/get?id=1`

### Read student by path variable

- `GET /api/students/get/1`

### Read all students

- `GET /api/students/getAll`

### Update student

- `PUT /api/students/update?id=1`
- Request body example:

```json
{
  "name": "John Doe",
  "age": 21,
  "email": "john.doe@example.com",
  "rollNo": 101,
  "subject": "Physics"
}
```

### Delete student

- `DELETE /api/students/delete?id=1`

## Notes

- The `Student` entity currently defines `id` as the primary key but does not include `@GeneratedValue`, so the client should provide the `id` value when creating a new student.
- If the app cannot start, verify MySQL is running and the `crud_db` database exists.
- If you want standard REST-style endpoints, you can simplify routes to `/api/students/{id}`.
