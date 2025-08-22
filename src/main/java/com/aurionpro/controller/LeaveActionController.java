package com.aurionpro.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.model.LeaveManagementModel;
import com.aurionpro.model.UserModel;
import com.aurionpro.service.UserService;

/**
 * Servlet implementation class LeaveActionController
 */
@WebServlet("/LeaveActionController")
public class LeaveActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveActionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action")!=null) {
			LeaveManagementModel leave= new LeaveManagementModel();
			leave.setLeaveId(Integer.parseInt(request.getParameter("leaveId")));
			leave.setStatus(request.getParameter("action"));
			System.out.println(leave.getStatus());
			UserService.updateLeave(leave);
		}
		
		List<LeaveManagementModel> leaves = UserService.getPendingLeave();
		Collections.reverse(leaves); 
		request.setAttribute("leaves", leaves);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewPendingLeaves.jsp");
		dispatcher.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
