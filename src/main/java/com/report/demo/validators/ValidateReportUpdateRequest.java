package com.report.demo.validators;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.report.demo.reportEnum.ErrorCodeEnum;
import com.report.demo.reportEnum.ReportStateEnum;
import com.report.demo.requests.UpdateReportRequest;

@Component
public class ValidateReportUpdateRequest implements Validator, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3259004451966719933L;

	@Override
	public boolean supports(Class<?> clazz) {
		return UpdateReportRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(target instanceof UpdateReportRequest) {
			UpdateReportRequest updateReportRequest = (UpdateReportRequest) target;
			
			if(updateReportRequest.getTicketState().isEmpty() || 
					!ReportStateEnum.isReportStateEnum(updateReportRequest.getTicketState())) {
			
				errors.rejectValue("ticketState", ErrorCodeEnum.INVALID_REPORT_STATE.getErrorCode(), null, null);
				return;
			}
		}
	}

}
