package com.report.demo.reportEnum;

public enum ReportTypeEnum {
	SPAM("SPAM"),
	INFRINGES_PROPERTY("INFRINGES_PROPERTY"),
	VIOLATES_POLICIES("VIOLATES_POLICIES");
	
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
