package com.report.demo.reportEnum;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum ReportStateEnum {
	OPEN("Open"),
	CLOSED("Closed");
	
	private String state;
	
	private ReportStateEnum(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public static Boolean isReportStateEnum(String checkState) {
        boolean isReportState = Arrays.stream(ReportStateEnum.values())
        			.map(Enum::name)
        			.collect(Collectors.toList())
        			.contains(checkState);
        
        return isReportState;
	}
	
	public static ReportStateEnum getReportEnum(String checkState) {
		return ReportStateEnum.valueOf(checkState);
	}
}
