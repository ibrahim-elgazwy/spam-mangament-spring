package com.report.demo.dto;

import java.io.Serializable;

import com.report.demo.reportEnum.ReportStateEnum;
import com.report.demo.reportEnum.ReportTypeEnum;

public class ReportDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7089523386370422093L;

	private Integer id;
	
	private String source;
	
	private String message;
	
	private ReportStateEnum state;

	private ReportTypeEnum type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getState() {
		return state.getState();
	}

	public void setState(ReportStateEnum state) {
		this.state = state;
	}

	public String getType() {
		return type.getType();
	}

	public void setType(ReportTypeEnum type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
