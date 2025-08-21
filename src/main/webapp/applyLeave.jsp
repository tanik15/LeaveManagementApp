<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ApplyLeave</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: #f8f9fa;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .leave-form-container {
            max-width: 600px;
            margin: 50px auto;
            background: #ffffff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 6px 12px rgba(0,0,0,0.1);
        }
        .form-title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 25px;
            text-align: center;
            color: #2c3e50;
        }
        .btn-custom {
            background-color: #198754;
            color: white;
            border-radius: 8px;
            transition: 0.3s;
        }
        .btn-custom:hover {
            background-color: #157347;
        }
    </style>
</head>
<body>

<% 
    if (session == null || session.getAttribute("userid") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>


    <div class="leave-form-container">
        <div class="form-title">Apply for Leave</div>
        
        <!-- Leave Application Form -->
        <form action="LeaveController" method="post">
            
           

            <!-- From Date -->
            <div class="mb-3">
                <label for="fromDate" class="form-label">From Date</label>
                <input type="date" class="form-control" id="fromDate" name="fromDate" required>
            </div>

            <!-- To Date -->
            <div class="mb-3">
                <label for="toDate" class="form-label">To Date</label>
                <input type="date" class="form-control" id="toDate" name="toDate" required>
            </div>

            <!-- Reason -->
            <div class="mb-3">
                <label for="reason" class="form-label">Reason</label>
                <textarea class="form-control" id="reason" name="reason" rows="4" maxlength="200" placeholder="Enter your reason..." required></textarea>
            </div>

            <!-- Status (default: Pending, hidden) -->
            <input type="hidden" name="status" value="Pending">

            <!-- Submit Button -->
            <div class="d-grid">
                <button type="submit" class="btn btn-custom btn-lg">Submit Application</button>
            </div>
        </form>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>