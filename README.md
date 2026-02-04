# 🎓 Student Result Management System

A Java-based **Student Result Management System** built using **Servlets, JSP, JDBC**, and **MySQL**, styled with **Bootstrap 5**.  
The application allows adding student results with validation and viewing results in a clean, tabular format.

---

## 🚀 Features

- ➕ Add student results (Roll No, Name, Marks)
- 🔒 Prevent duplicate roll numbers (DB-level constraint)
- ✅ Server-side validation for inputs
- 📊 View all student results in a Bootstrap-styled table
- 🎨 Clean and responsive UI using Bootstrap 5
- 🛠 Proper JDBC connection handling

---

## 🧰 Tech Stack

- **Backend:** Java (Servlets, JDBC)
- **Frontend:** JSP, HTML, CSS, Bootstrap 5
- **Database:** MySQL
- **Server:** Apache Tomcat 10.1
- **IDE:** Eclipse

---

## 🗂 Project Structure
StudentResultSystem
└─ src
└─ main
├─ java
│ └─ com.student
│ ├─ dao (Database operations)
│ ├─ db (DB connection)
│ ├─ model (Student model)
│ └─ servlet (Servlet controllers)
└─ webapp
├─ index.jsp
├─ css
│ └─ style.css
└─ WEB-INF
└─ lib
└─ mysql-connector-j.jar



---

## 🛢 Database Setup

### 1️⃣ Create Database
```sql
CREATE DATABASE student_result_db;
USE student_result_db;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    roll_no VARCHAR(20) UNIQUE,
    name VARCHAR(100),
    marks INT
);



👤 Author

Paarth Sharma






