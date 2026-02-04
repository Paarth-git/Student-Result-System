package com.student.servlet;

import java.io.IOException;

import com.student.dao.StudentDAO;
import com.student.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("AddStudentServlet HIT");

        // Read parameters
        String rollNo = request.getParameter("rollNo");
        String name = request.getParameter("name");
        String marksStr = request.getParameter("marks");

        // 🔴 Validate roll number
        if (rollNo == null || rollNo.trim().isEmpty()) {
            response.sendRedirect("index.jsp?error=invalidRoll");
            return;
        }
        rollNo = rollNo.trim();

        // 🔴 Validate name
        if (name == null || name.trim().isEmpty()) {
            response.sendRedirect("index.jsp?error=invalidName");
            return;
        }
        name = name.trim();

        // 🔴 Validate marks
        int marks;
        try {
            marks = Integer.parseInt(marksStr);
        } catch (NumberFormatException e) {
            response.sendRedirect("index.jsp?error=invalidMarks");
            return;
        }

        System.out.println("RollNo: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);

        // Insert into DB
        Student student = new Student(rollNo, name, marks);
        StudentDAO dao = new StudentDAO();

        boolean added = dao.addStudent(student);

        if (added) {
            System.out.println("Student inserted successfully");
            response.sendRedirect("index.jsp?success=true");
        } else {
            System.out.println("Duplicate roll number blocked");
            response.sendRedirect("index.jsp?error=duplicate");
        }
    }
}
