package com.report.demo.reportEnum;

public enum ErrorCodeEnum {
	UNUATHORIZED_USER(
			"UNUATHORIZED_USER", 
			"unauthorized user, user must be login", 
			"user must be login"),
	HTTP_STATUS_404_NOT_FOUND(
			"HTTP_STATUS_404_NOT_FOUND", 
			 "The origin server did not find a current representation for the target resource", 
			 "check resource url"),
	NOT_FOIND_REQUEST_ID(
			"NOT_FOIND_REQUEST_ID", 
			"report id not founded, please check valid report id", 
			"check report id"),
	INVALID_REPORT_STATE(
			"INVALID_REPORT_STATE", 
			"Unvalid Report state", 
			"please provide appropiate valid state");;
	
	private String errorCode;
	private String errorDescription;
	private String fixSuggestion;
	
	private ErrorCodeEnum(String errorCode, 
						  String errorDescription, 
						  String fixSuggestion) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.fixSuggestion = fixSuggestion;
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

	public static ErrorCodeEnum getErrorCode(String code) {
		return ErrorCodeEnum.valueOf(code);
	}
}
