package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.student.db.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewResults")
public class ViewResultsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Student Results</title>");

            // Bootstrap CDN
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet'>");

            out.println("</head>");
            out.println("<body class='bg-light'>");

            out.println("<div class='container mt-5'>");
            out.println("<h3 class='text-center mb-4'>Student Results</h3>");

            out.println("<table class='table table-bordered table-striped table-hover'>");
            out.println("<thead class='table-dark'>");
            out.println("<tr>");
            out.println("<th>Roll No</th>");
            out.println("<th>Name</th>");
            out.println("<th>Marks</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps =
                         con.prepareStatement("SELECT roll_no, name, marks FROM students");
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getString("roll_no") + "</td>");
                    out.println("<td>" + rs.getString("name") + "</td>");
                    out.println("<td>" + rs.getInt("marks") + "</td>");
                    out.println("</tr>");
                }
            }

            out.println("</tbody>");
            out.println("</table>");

            out.println("<div class='text-center'>");
            out.println("<a href='index.jsp' class='btn btn-secondary'>Back</a>");
            out.println("</div>");

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            throw new ServletException("Error fetching student results", e);
        }
    }
}
