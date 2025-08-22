<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Information</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	background: #f8f9fa;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.info-container {
	max-width: 600px;
	margin: 60px auto;
	background: #ffffff;
	padding: 30px;
	border-radius: 12px;
	box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
}

.info-title {
	font-size: 24px;
	font-weight: bold;
	margin-bottom: 25px;
	text-align: center;
	background-color: #198754;
	color: white;
	padding: 6px;
	border-radius: 4px;
}

.info-item {
	font-size: 16px;
	margin-bottom: 12px;
}

.info-item strong {
	color: #2c3e50;
}

.logout-button {
  margin: 0 auto; /* Centers horizontally */
  width: 50%;
  text-align: center;
}
</style>

</head>
<body>

	<%
	if (session == null || session.getAttribute("userid") == null) {
		response.sendRedirect("login.jsp");
		return;
	}
	String email = request.getParameter("email");
	String userid = request.getParameter("userid");
	String role = request.getParameter("role");
	String userName = request.getParameter("userName");
	String userDept = request.getParameter("userDept");
	%>
	<div class="info-container">
		<div class="info-title">User Information</div>

		<!-- User Information Card -->
		<div>
			<p class="info-item">
				<strong>User ID:</strong> ${userid}
			</p>
			<p class="info-item">
				<strong>User Name:</strong> ${userName}
			</p>
			<p class="info-item">
				<strong>Email:</strong> ${email}
			</p>
			<p class="info-item">
				<strong>Department:</strong> ${userDept}
			</p>
			<p class="info-item">
				<strong>Role:</strong> ${role}
			</p>

		</div>
		
		<%
		if ("admin".equalsIgnoreCase(role)) {
		%>
		<!-- Logout Button -->
		<div class="d-flex justify-content-between mt-4">
			<!-- Apply Leave Button -->
			<form action="LeaveActionController" method="get">
				<button type="submit" class="btn btn-success btn-lg">View
					Pending Leaves</button>
			</form>

			<!-- View Applied Leave Button -->
			<form action="allLeaveController" method="get">
				<button type="submit" class="btn btn-primary btn-lg">View
					All Leave</button>
			</form>


		</div>
		<br>
		<div class="logout-button" >
			<form action="LogoutController" method="get">
				<button type="submit" class="btn btn-danger btn-lg">Logout</button>
			</form>
		</div>
		<%
		}
		%>
		
		<%
		if (!"admin".equalsIgnoreCase(role)) {
		%>
		<!-- Logout Button -->
		<div class="d-flex justify-content-between mt-4">
			<!-- Apply Leave Button -->
			<form action="applyLeave.jsp" method="get">
				<button type="submit" class="btn btn-success btn-lg">Apply
					Leave</button>
			</form>

			<!-- View Applied Leave Button -->
			<form action="ViewLeaveController" method="get">
				<button type="submit" class="btn btn-primary btn-lg">View
					Applied Leave</button>
			</form>

			<form action="LogoutController" method="get">
				<button type="submit" class="btn btn-danger btn-lg">Logout</button>
			</form>
		</div>
		<%
		}
		%>
		


	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>