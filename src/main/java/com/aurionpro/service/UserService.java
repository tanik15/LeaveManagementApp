package com.aurionpro.service;

import java.util.List;

import com.aurionpro.dao.UserDao;
import com.aurionpro.model.LeaveManagementModel;
import com.aurionpro.model.UserModel;

public class UserService {
	
	public static UserModel checkUser(UserModel user) {
		UserDao userdao= new UserDao();
		return userdao.checkUser(user);
	}
	
	public static boolean applyLeave(LeaveManagementModel leave) {
		UserDao userdao= new UserDao();
		return userdao.applyLeave(leave);
	}
	
	public static List<LeaveManagementModel> getPendingLeave() {
		UserDao userdao= new UserDao();
		return userdao.getPendingLeave();
	}
	
	public static List<LeaveManagementModel> getAllLeave() {
		UserDao userdao= new UserDao();
		return userdao.getAllLeave();
	}
	
	public static List<LeaveManagementModel> getUserLeave(UserModel user) {
		UserDao userdao= new UserDao();
		return userdao.getUserLeave(user);
	}
	
	public static boolean updateLeave(LeaveManagementModel leave) {
		UserDao userdao= new UserDao();
		return userdao.updatePendingLeave(leave);
	}
}
