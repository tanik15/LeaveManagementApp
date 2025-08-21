package com.aurionpro.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.model.LeaveManagementModel;
import com.aurionpro.service.UserService;

/**
 * Servlet implementation class LeaveController
 */
@WebServlet("/LeaveController")
public class LeaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LeaveController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userid = (int) session.getAttribute("userid");
		String fromDate = request.getParameter("fromDate");
		System.out.println(fromDate);
		String toDate = request.getParameter("toDate");
		String reason = request.getParameter("reason");
		LocalDate frommDate = LocalDate.parse(fromDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Date fromsqlDate = Date.valueOf(frommDate);
		LocalDate tooDate = LocalDate.parse(toDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Date tosqlDate = Date.valueOf(tooDate);
		LeaveManagementModel leave = new LeaveManagementModel();
		leave.setUserId(userid);
		leave.setFromDate(fromsqlDate);
		leave.setToDate(tosqlDate);
		leave.setReason(reason);
		if( UserService.applyLeave(leave)) {
			response.sendRedirect("response.jsp?status=success");
		}else {
		    response.sendRedirect("response.jsp?status=fail");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
