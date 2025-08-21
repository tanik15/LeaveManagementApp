package com.aurionpro.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.model.UserModel;
import com.aurionpro.service.UserService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("userid"));
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		Boolean isadmin = (role.equalsIgnoreCase("admin"))?true: false;
		UserModel user = new UserModel();
		user.setUserId(userid);
		user.setPassword(password);
		user.setAdmin(isadmin);
		System.out.println(userid+" " +password+" "+isadmin);
		RequestDispatcher dispatcher = null;
		boolean isValidUser = (UserService.checkUser(user)==null)?false:true;
		if(isValidUser) {
			if(isadmin) {
				dispatcher = request.getRequestDispatcher("adminView.jsp");
			}else {
				UserModel userResponse = UserService.checkUser(user);
				HttpSession session = request.getSession();
				session.setAttribute("userid", userid);
				session.setAttribute("role", role);
				session.setAttribute("email", userResponse.getEmail());
				session.setAttribute("userDept", userResponse.getUserDept());
				session.setAttribute("userName", userResponse.getUserName());
				dispatcher = request.getRequestDispatcher("myInfo.jsp");				
			}
			dispatcher.forward(request, response);
		}else {
			dispatcher = request.getRequestDispatcher("failed.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
