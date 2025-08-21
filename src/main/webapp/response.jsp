<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Response</title>
</head>
<body
	style="margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; background-color: #f4f6f9; font-family: Arial, sans-serif;">
	<%
	String status = request.getParameter("status");
	String message = "";
	String color = "";
	if ("success".equals(status)) {
		message = "Leave applied successfully!";
		color = "#28a745"; // green
	} else if ("fail".equals(status)) {
		message = "Leave application failed!";
		color = "#dc3545"; // red
	}
	%>

	<%
	if (!message.isEmpty()) {
	%>
	<div
		style="background: white; padding: 40px; border-radius: 12px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15); text-align: center; width: 400px;">
		<h2 style="color:<%=color%>; margin-bottom:20px;"><%=message%></h2>
		<form action="myInfo.jsp">
			<button
				style="padding:10px 20px; background-color:<%=color%>; color:white; border:none; border-radius:8px; cursor:pointer; font-size:16px;">Okay</button>
		</form>
	</div>
	<%
	}
	%>



</body>
</html>