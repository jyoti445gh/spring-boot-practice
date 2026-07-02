# 🚀 Spring Boot Annotations and Configuration

A beginner-friendly Spring Boot project demonstrating the fundamental concepts of **Spring Boot Annotations, Dependency Injection, Component Scanning, Auto Configuration, and Application Startup**.

---

## 📚 Overview

Spring Boot is built on top of Spring Framework. It simplifies application development by automatically configuring the Spring container, managing dependencies, and reducing boilerplate configuration.

Unlike Spring Core, where developers manually create the IoC container and configure beans, Spring Boot starts and configures the application automatically using:

- `SpringApplication.run()`
- `@SpringBootApplication`
- Auto Configuration
- Component Scanning

---

## 🛠 Technologies Used

- Java 17
- Spring Boot 3.x
- Maven
- IntelliJ IDEA

---

# 📂 Project Structure

```text
SpringBootAnnotationsDemo
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── org.example
│   │   │       ├── SpringBootAnnotationsDemoApplication.java
│   │   │       ├── PaymentService.java
│   │   │       ├── OrderService.java
│   │   │       ├── AppRunner.java
│   │   │       └── AppConfig.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│
├── pom.xml
├── .gitignore
└── README.md
```

---

# 🌱 Spring Boot Startup Flow

```mermaid
flowchart TD

A[Application Starts]
B[SpringApplication.run()]
C[Application Context Created]
D[Component Scanning]
E[Register User Beans]
F[Auto Configuration]
G[Dependency Injection]
H[Application Context Ready]
I[CommandLineRunner Executes]

A --> B
B --> C
C --> D
D --> E
E --> F
F --> G
G --> H
H --> I
```

---

# 📖 Topics Covered

## 1️⃣ Spring Core vs Spring Boot

| Spring Core | Spring Boot |
|--------------|-------------|
| Manual Configuration | Automatic Configuration |
| Manual IoC Container | Automatic Startup |
| Manual Bean Retrieval | Dependency Injection |
| More Configuration | Less Configuration |

---

## 2️⃣ SpringApplication.run()

Starts the Spring Boot application.

```java
@SpringBootApplication
public class SpringBootAnnotationsDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(
            SpringBootAnnotationsDemoApplication.class,
            args
        );
    }

}
```

---

## 3️⃣ @SpringBootApplication

This annotation combines

- `@SpringBootConfiguration`
- `@EnableAutoConfiguration`
- `@ComponentScan`

```java
@SpringBootApplication
public class SpringBootAnnotationsDemoApplication {

}
```

---

## 4️⃣ @Component

Marks a Java class as a Spring Bean.

```java
@Component
public class PaymentService {

    public void pay() {

        System.out.println("Payment Successful");

    }

}
```

---

## 5️⃣ Constructor Dependency Injection

```java
@Component
public class OrderService {

    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {

        this.paymentService = paymentService;

    }

    public void placeOrder(){

        paymentService.pay();

        System.out.println("Order Placed");

    }

}
```

---

## 6️⃣ CommandLineRunner

Runs after the Spring Boot application starts.

```java
@Component
public class AppRunner implements CommandLineRunner {

    private final OrderService orderService;

    public AppRunner(OrderService orderService){

        this.orderService = orderService;

    }

    @Override
    public void run(String... args){

        orderService.placeOrder();

    }

}
```

---

## 7️⃣ @ComponentScan

Automatically scans the current package and all sub-packages for Spring Beans.

---

## 8️⃣ @EnableAutoConfiguration

Automatically configures Spring Boot based on:

- Dependencies
- Classpath
- Existing Beans
- Configuration Properties

---

## 9️⃣ Auto Configuration

Spring Boot automatically configures:

- DataSource
- Jackson
- Spring MVC
- Embedded Tomcat
- Task Executor

Only when required dependencies are available.

---

## 🔟 Conditional Annotations

### @ConditionalOnClass

Creates configuration only if a class exists.

### @ConditionalOnMissingBean

Creates a bean only if no custom bean already exists.

---

# 🔄 Spring Boot Startup Process

```text
Application Starts
        │
        ▼
SpringApplication.run()
        │
        ▼
Application Context Created
        │
        ▼
Component Scanning
        │
        ▼
Register User Beans
        │
        ▼
Auto Configuration
        │
        ▼
Dependency Injection
        │
        ▼
Application Context Ready
        │
        ▼
CommandLineRunner Executes
```

---

# ▶️ How to Run

### Clone Repository

```bash
git clone https://github.com/jyoti445gh/spring-boot-practice.git
```

---

### Navigate to Project

```bash
cd SpringBootAnnotationsDemo
```

---

### Run

```bash
mvn spring-boot:run
```

or run

```
SpringBootAnnotationsDemoApplication.java
```

from IntelliJ IDEA.

---

# 📌 Expected Output

```text
Payment Successful

Order Placed
```

---

# 🎯 Learning Outcomes

After completing this project you will understand:

- Spring Boot Architecture
- SpringApplication.run()
- @SpringBootApplication
- @Component
- Constructor Injection
- Dependency Injection
- CommandLineRunner
- Component Scanning
- Auto Configuration
- Conditional Annotations
- Spring Boot Startup Flow

---

# 📚 References

- Spring Boot Documentation
- Spring Framework Documentation
- Spring Boot Annotations and Configuration Notes

---

# 👩‍💻 Author

**Jyoti Nehara**

B.Tech Computer Science & Engineering

Learning Spring Boot 🚀