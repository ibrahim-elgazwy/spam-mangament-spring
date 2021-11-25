package com.report.demo.reportEnum;

public enum ReportTypeEnum {
	SPAM("Spam"),
	INFRINGES_PROPERTY("Infringes Property"), 
	VIOLATES_POLICIES("Violates Polices");
	
	private String type;
	
	private ReportTypeEnum(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
