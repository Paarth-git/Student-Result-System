package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

import com.student.db.DBConnection;
import com.student.model.Student;

public class StudentDAO {

    public boolean addStudent(Student student) {
    	System.out.println(">>> StudentDAO.addStudent() CALLED <<<");


        String sql = "INSERT INTO students (roll_no, name, marks) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.println("DAO rollNo = " + student.getRollNo());
            System.out.println("DAO name = " + student.getName());
            System.out.println("DAO marks = " + student.getMarks());

            ps.setString(1, student.getRollNo());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getMarks());

            int rows = ps.executeUpdate();
            System.out.println("Rows inserted = " + rows);

            return rows > 0;

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("❌ UNIQUE constraint violated (real duplicate)");
            return false;

        } catch (Exception e) {
            System.out.println("❌ REAL DB ERROR (not duplicate):");
            e.printStackTrace();
            return false;
        }
    }
}
