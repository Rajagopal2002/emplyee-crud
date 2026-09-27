# Employee CRUD - Spring Boot Project

A simple Employee Management web app (Insert / Update / Delete / View) built with:
- Spring Boot 3.3.4
- Spring Data JPA (Hibernate)
- PostgreSQL
- Thymeleaf + Bootstrap 5 (UI)

## 1. Prerequisites

- Java 17 (JDK 17 or later)
- Maven (NetBeans has this bundled — no separate install needed)
- PostgreSQL installed and running
- NetBeans IDE (2021+ recommended) with Maven support

## 2. Create the Database

Open pgAdmin or `psql` and run:

```sql
CREATE DATABASE employee_db;
```

The app will automatically create the `employees` table on first run (`ddl-auto=update`).

## 3. Configure Database Credentials

Already set in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/employee_db
spring.datasource.username=postgres
spring.datasource.password=sql12345
```

If your PostgreSQL username, port, or password is different, update this file.

## 4. Open in IntelliJ IDEA

1. Open IntelliJ IDEA → **File → Open**
2. Select the `employee-crud` folder (or the `pom.xml` file inside it)
3. IntelliJ detects it as a Maven project and shows a popup/notification to **"Load Maven Project"** — click it (or click the Maven refresh icon in the top-right Maven panel)
4. Wait for IntelliJ to download dependencies (first time only — watch the progress bar at the bottom)
5. In the Project panel, navigate to `src/main/java/com/example/employeecrud/EmployeeCrudApplication.java`
6. Click the green **▶ Run** arrow next to the `main` method (or right-click the file → **Run 'EmployeeCrudApplication'**)

IntelliJ will build and start the app; watch the **Run** console at the bottom for "Started EmployeeCrudApplication".

> Make sure IntelliJ is using **JDK 17** (File → Project Structure → Project → SDK). If not installed, IntelliJ can download it for you from that same dialog.

### Alternative: Open in NetBeans

1. Open NetBeans → **File → Open Project**
2. Select the `employee-crud` folder (it's a Maven project, NetBeans will detect it automatically)
3. Wait for NetBeans to download dependencies (first time only)
4. Right-click the project → **Run** (or press F6)

NetBeans will run `EmployeeCrudApplication.java` automatically since it has the `main()` method.

## 5. Open the App

Once it starts (look for "Started EmployeeCrudApplication" in the output console), open your browser:

```
http://localhost:8080
```

This redirects to the employee list page where you can:
- **View** all employees
- **Add** a new employee
- **Edit** an existing employee
- **Delete** an employee

## 6. Project Structure

```
employee-crud/
├── pom.xml
├── src/main/java/com/example/employeecrud/
│   ├── EmployeeCrudApplication.java     (main class)
│   ├── model/Employee.java              (entity)
│   ├── repository/EmployeeRepository.java
│   ├── service/EmployeeService.java
│   └── controller/
│       ├── EmployeeController.java      (CRUD endpoints)
│       └── HomeController.java          (redirects "/" to list page)
└── src/main/resources/
    ├── application.properties           (DB config)
    ├── templates/
    │   ├── employee-list.html
    │   └── employee-form.html
    └── static/css/style.css
```

## Troubleshooting

- **Connection refused / DB error**: Make sure PostgreSQL service is running and `employee_db` exists.
- **Port 8080 already in use**: Change `server.port` in `application.properties`.
- **Wrong password auth error**: Double check the PostgreSQL user's password matches `application.properties`.
