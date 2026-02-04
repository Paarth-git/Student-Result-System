<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Result System</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container d-flex justify-content-center">
    <div class="container-box">

        <h3 class="text-center mb-4">Student Result System</h3>

        <!-- 🔔 Alerts Section -->
        <%
            String error = request.getParameter("error");
            String success = request.getParameter("success");
        %>

        <% if ("invalidRoll".equals(error)) { %>
            <div class="alert alert-danger">Roll number cannot be empty.</div>
        <% } %>

        <% if ("invalidName".equals(error)) { %>
            <div class="alert alert-danger">Name cannot be empty.</div>
        <% } %>

        <% if ("invalidMarks".equals(error)) { %>
            <div class="alert alert-danger">Marks must be a valid number.</div>
        <% } %>

        <% if ("duplicate".equals(error)) { %>
            <div class="alert alert-warning">Roll number already exists.</div>
        <% } %>

        <% if ("true".equals(success)) { %>
            <div class="alert alert-success">Student added successfully.</div>
        <% } %>

        <!-- 📋 Student Form -->
        <form action="addStudent" method="post">

            <div class="mb-3">
                <label class="form-label">Roll No</label>
                <input type="text" name="rollNo" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Name</label>
                <input type="text" name="name" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Marks</label>
                <input type="number" name="marks" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary w-100">
                Add Student
            </button>

        </form>

        <div class="text-center mt-3">
            <a href="viewResults" class="btn btn-outline-secondary">
                View Results
            </a>
        </div>

    </div>
</div>

</body>
</html>
