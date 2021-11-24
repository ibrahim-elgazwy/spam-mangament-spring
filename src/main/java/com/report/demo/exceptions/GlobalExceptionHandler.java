package com.report.demo.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.report.demo.reportEnum.ErrorCodeEnum;
import com.report.demo.reportEnum.ReportException;
import com.report.demo.reportEnum.StatusEnum;
import com.report.demo.response.RestResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ReportException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody RestResponse handleReportException(ReportException reportException) {
		return new RestResponse(reportException);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody RestResponse handleValidationExcption(MethodArgumentNotValidException exception) {
		
		List<ReportError> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> {
                	return new ReportError(
                			ErrorCodeEnum.getErrorCode(err.getCode()), 
                			err.getArguments());
                })
                .collect(Collectors.toList());
		
		return new RestResponse(errors, StatusEnum.ERROR);
	}
}
