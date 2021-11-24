package com.report.demo.exceptions;

import com.report.demo.reportEnum.ErrorCodeEnum;
import com.report.demo.reportEnum.ReportException;

public class InvalidRequestIdException extends ReportException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 695933666412894073L;

	public InvalidRequestIdException(ErrorCodeEnum errorCodeEnum) {
		super(ErrorCodeEnum.NOT_FOIND_REQUEST_ID);
	}
}
