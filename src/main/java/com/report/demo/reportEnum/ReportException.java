package com.report.demo.reportEnum;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.report.demo.exceptions.ReportExceptionSerializer;


@JsonSerialize(using = ReportExceptionSerializer.class)
public class ReportException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3892715899841549506L;

	protected String errorCode;
	protected String errorDescription;

	public ReportException(ErrorCodeEnum errorCodeEnum) {
		errorCode = errorCodeEnum.getErrorCode();
		errorDescription = errorCodeEnum.getErrorDescription();
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getErrorDescription() {
		return errorDescription;
	}
	
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
}
