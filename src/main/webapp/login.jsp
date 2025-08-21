<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background: #f8f9fa;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }
    .login-form-container {
        max-width: 450px;
        margin: 80px auto;
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

    <div class="login-form-container">
        <div class="form-title">Login</div>

        <!-- Login Form -->
        <form action="UserController" method="post">
            
            <!-- User ID -->
            <div class="mb-3">
                <label for="userid" class="form-label fw-bold">User ID</label>
                <input type="text" class="form-control" id="userid" name="userid" placeholder="Enter User ID" required>
            </div>

            <!-- Password -->
            <div class="mb-3">
                <label for="password" class="form-label fw-bold">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
            </div>

            <!-- Role -->
            <div class="mb-3">
                <label for="role" class="form-label fw-bold">Role</label>
                <input type="text" class="form-control" id="role" name="role" placeholder="Enter Role (e.g. Admin/User)" required>
            </div>

            <!-- Login Button -->
            <div class="d-grid">
                <button type="submit" class="btn btn-custom btn-lg">Login</button>
            </div>
        </form>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
