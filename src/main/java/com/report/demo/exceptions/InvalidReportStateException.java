package com.report.demo.exceptions;

import com.report.demo.reportEnum.ErrorCodeEnum;
import com.report.demo.reportEnum.ReportException;

public class InvalidReportStateException extends ReportException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5818132324447131239L;

	public InvalidReportStateException(ErrorCodeEnum errorCodeEnum) {
		super(ErrorCodeEnum.INVALID_REPORT_STATE);
	}
}
