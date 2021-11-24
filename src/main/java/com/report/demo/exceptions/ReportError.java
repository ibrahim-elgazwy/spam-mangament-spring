package com.report.demo.exceptions;

import java.io.Serializable;

import com.report.demo.reportEnum.ErrorCodeEnum;

public class ReportError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3301359904089303910L;

	private String errorCode;
	private String errorDescription;
	private String fixSuggestion;
	private Object target;
	private Object errorArguments;

	public ReportError(ErrorCodeEnum errorCodeEnum, Object errorArguments) {
		this.errorCode = errorCodeEnum.getErrorCode();
		this.errorDescription = errorCodeEnum.getErrorDescription();
		this.fixSuggestion = errorCodeEnum.getFixSuggestion();
		this.errorArguments = errorArguments;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public String getFixSuggestion() {
		return fixSuggestion;
	}

	public Object getTarget() {
		return target;
	}

	public Object getErrorArguments() {
		return errorArguments;
	}
}
