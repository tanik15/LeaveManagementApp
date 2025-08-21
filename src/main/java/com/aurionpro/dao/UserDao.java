package com.aurionpro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.database.DbSource;
import com.aurionpro.model.LeaveManagementModel;
import com.aurionpro.model.UserModel;

public class UserDao {
	private Connection connection;

	public UserDao() {
		connection = DbSource.getConnection();
	}

	public UserModel checkUser(UserModel user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select user_name, user_dept,email from user where user_id =? and password=? and is_admin=?");
			preparedStatement.setInt(1, user.getUserId());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setBoolean(3, user.isAdmin());
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				user.setUserName(result.getString(1));
				user.setUserDept(result.getString(2));
				user.setEmail(result.getString(3));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("false");
		return null;
	}

	public boolean applyLeave(LeaveManagementModel leaveModel) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO leave_summary (user_id, from_date, to_date, reason) VALUES (?, ?, ?, ?)");
			preparedStatement.setInt(1, leaveModel.getUserId());
			preparedStatement.setDate(2, leaveModel.getFromDate());
			preparedStatement.setDate(3, leaveModel.getToDate());
			preparedStatement.setString(4, leaveModel.getReason());
			int update = preparedStatement.executeUpdate();
			if (update > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public List<LeaveManagementModel> getPendingLeave(){
		List<LeaveManagementModel> leaves= new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from leave_summary where status = 'Pending'");
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()) {
				LeaveManagementModel leave = new LeaveManagementModel();
				leave.setLeaveId(result.getInt(1));
				leave.setUserId(result.getInt(2));
				leave.setAppliedDate(result.getTimestamp(3));
				leave.setFromDate(result.getDate(4));
				leave.setToDate(result.getDate(5));
				leave.setReason(result.getString(6));
				leave.setStatus(result.getString(7));
				leaves.add(leave);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leaves;
	}
	
	public boolean updatePendingLeave(LeaveManagementModel leave){
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update leave_summary set status=? where user_id=?");
			preparedStatement.setString(1, leave.getStatus());
			preparedStatement.setInt(2, leave.getUserId());
			int update = preparedStatement.executeUpdate();
			if(update>0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public List<LeaveManagementModel> getUserLeave(UserModel user){
		List<LeaveManagementModel> leaves= new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from leave_summary where user_id =? ");
			preparedStatement.setInt(1,user.getUserId() );
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()) {
				LeaveManagementModel leave = new LeaveManagementModel();
				leave.setLeaveId(result.getInt(1));
				leave.setUserId(result.getInt(2));
				leave.setAppliedDate(result.getTimestamp(3));
				leave.setFromDate(result.getDate(4));
				leave.setToDate(result.getDate(5));
				leave.setReason(result.getString(6));
				leave.setStatus(result.getString(7));
				leaves.add(leave);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leaves;
	}
}
