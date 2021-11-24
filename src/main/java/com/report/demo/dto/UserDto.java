package com.report.demo.dto;

import java.io.Serializable;

import com.report.demo.reportEnum.ReportStateEnum;
import com.report.demo.reportEnum.UserRoleEnum;

public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8489695066110227835L;
	
	private Integer id;

	private String userName;

	private String email;
	
	private UserRoleEnum role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRoleEnum getRole() {
		return role;
	}

	public void setRole(UserRoleEnum role) {
		this.role = role;
	}
}
