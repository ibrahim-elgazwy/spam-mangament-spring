package com.report.demo.reportEnum;

public enum UserRoleEnum {
	ADMIN("ADMIN"),
	USER("USER");
	
	private String role;
	
	private UserRoleEnum(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
