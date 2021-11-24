package com.report.demo.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.report.demo.reportEnum.ReportException;
import com.report.demo.reportEnum.StatusEnum;

public class RestResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6847540211257597939L;

	private StatusEnum status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String errorCode;
	private String errorDescription;
	private String fixSuggestion;
	private Object body;

	public RestResponse(Object body) {
		if (body instanceof ReportException) {
			ReportException bookStoreException = (ReportException) body;
			status = StatusEnum.ERROR;
			errorCode = bookStoreException.getErrorCode();
			errorDescription = bookStoreException.getErrorDescription();
		} else {
			status = StatusEnum.OK;
		}

		this.body = body;
	}

	public RestResponse(Object body, StatusEnum status) {
		this.status = status;
		this.body = body;
	}

	public RestResponse(String errorCode, String errorDescription) {
		this.status = StatusEnum.ERROR;
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return LocalDateTime.now();
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
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

	public String getFixSuggestion() {
		return fixSuggestion;
	}

	public void setFixSuggestion(String fixSuggestion) {
		this.fixSuggestion = fixSuggestion;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}
}
