# Employee CRUD – Spring Boot

A simple Employee Management web application built with Spring Boot. The application supports creating, viewing, updating, and deleting employee records.

## Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* PostgreSQL
* Thymeleaf
* Bootstrap 5
* Maven

## Features

* Add employee
* View all employees
* Edit employee
* Delete employee
* Form validation
* PostgreSQL database integration
* Responsive web interface

## Project Structure

```text
employee-crud/
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/employeecrud/
│       │       ├── EmployeeCrudApplication.java
│       │       ├── controller/
│       │       │   ├── EmployeeController.java
│       │       │   └── HomeController.java
│       │       ├── model/
│       │       │   └── Employee.java
│       │       ├── repository/
│       │       │   └── EmployeeRepository.java
│       │       └── service/
│       │           └── EmployeeService.java
│       └── resources/
│           ├── application.properties
│           ├── templates/
│           │   ├── employee-list.html
│           │   └── employee-form.html
│           └── static/
│               └── css/
│                   └── style.css
└── .gitignore
```

## Database Configuration

This project uses PostgreSQL.

For local development, create a database:

```sql
CREATE DATABASE employee_db;
```

Database credentials should **not** be stored directly in GitHub.

Configure them using environment variables:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

Example environment variables for local development:

```text
DB_URL=jdbc:postgresql://localhost:5432/employee_db
DB_USERNAME=postgres
DB_PASSWORD=your_password
```

Replace `your_password` with your actual PostgreSQL password.

## Running the Application

### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA.
2. Open the Maven project from `pom.xml`.
3. Wait for Maven dependencies to download.
4. Open:

```text
EmployeeCrudApplication.java
```

5. Click the green **Run ▶** button.
6. Open:

```text
http://localhost:8080
```

The application redirects to the employee management page.

## Maven

To build the application:

```bash
mvn clean package
```

The generated JAR file will be inside:

```text
target/
```

## Deployment

This project can be deployed as a Spring Boot JAR using a cloud platform such as Render.

The production database credentials should be configured through the platform's environment variables rather than committed to the source code.

## Security

Do not commit:

* Database passwords
* API keys
* Access tokens
* Other private credentials

Use environment variables for sensitive configuration.

## Author

Rajagopal
