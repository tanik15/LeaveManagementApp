package com.aurionpro.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class LeaveManagementModel {
    private int leaveId;              // PRIMARY KEY AUTO_INCREMENT
    private int userId;               // FOREIGN KEY (user.user_id)
    private Timestamp appliedDate; // DATETIME DEFAULT CURRENT_TIMESTAMP
    private Date fromDate;        // DATE
    private Date toDate;          // DATE
    private String reason;             // VARCHAR(200)
    private String status;             // VARCHAR(45) DEFAULT "Pending"
    private String userName;
    private String userDept;
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDept() {
		return userDept;
	}

	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}

	// Default Constructor
    public LeaveManagementModel() {
    }

    // Parameterized Constructor
    public LeaveManagementModel(int leaveId, int userId, Timestamp appliedDate,
                                Date fromDate, Date toDate, String reason, String status) {
        this.leaveId = leaveId;
        this.userId = userId;
        this.appliedDate = appliedDate;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reason = reason;
        this.status = status;
    }

    // Getters and Setters
    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Timestamp appliedDate) {
        this.appliedDate = appliedDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
