<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*, com.aurionpro.model.LeaveManagementModel"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Leaves</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	background: #f8f9fa;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.leave-table-container {
	max-width: 900px;
	margin: 60px auto;
	background: #ffffff;
	padding: 30px;
	border-radius: 12px;
	box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
}

.table thead {
	background-color: #198754;
	color: white;
}

.table tbody tr:hover {
	background-color: #f1f1f1;
}

.page-title {
	font-size: 24px;
	font-weight: bold;
	margin-bottom: 25px;
	text-align: center;
	color: #2c3e50;
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
	<div class="leave-table-container">
		<div class="page-title">My Leave Applications</div>

		<!-- Leave Applications Table -->
		<table class="table table-hover table-bordered align-middle">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">From Date</th>
					<th scope="col">To Date</th>
					<th scope="col">Reason</th>
					<th scope="col">Status</th>
				</tr>
			</thead>
			<tbody>
				<%
				int num = 0;
				// Assume you set "userLeaves" in request from your Servlet
				List<LeaveManagementModel> userLeaves = (List<LeaveManagementModel>) request.getAttribute("leaves");
				if (userLeaves != null && !userLeaves.isEmpty()) {
					for (LeaveManagementModel leave : userLeaves) {
						num++;
				%>
				<tr>
					<td><%=num%></td>
					<td><%=leave.getFromDate()%></td>
					<td><%=leave.getToDate()%></td>
					<td><%=leave.getReason()%></td>
					<td>
						<%
						if ("Pending".equalsIgnoreCase(leave.getStatus())) {
						%> <span class="badge bg-warning text-dark">Pending</span> <%
 } else if ("Approved".equalsIgnoreCase(leave.getStatus())) {
 %> <span class="badge bg-success">Approved</span> <%
 } else {
 %> <span class="badge bg-danger">Rejected</span> <%
 }
 %>
					</td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="5" class="text-center text-muted">No leave
						applications found</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>

		<!-- Back / Logout Buttons -->
		<div class="d-flex justify-content-between mt-4">
			<a href="applyLeave.jsp" class="btn btn-success btn-lg">Apply New
				Leave</a>
			<form action="myInfo.jsp" method="get">
				<button type="submit" class="btn btn-danger btn-lg">Back</button>
			</form>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>