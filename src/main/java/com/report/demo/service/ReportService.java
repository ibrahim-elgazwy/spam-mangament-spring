package com.report.demo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.report.demo.domain.Report;
import com.report.demo.reportEnum.ReportException;
import com.report.demo.reportEnum.ReportStateEnum;
import com.report.demo.response.PagingResponse;

public interface ReportService {
	List<Report> finalAllReports();
	
	PagingResponse findReportsByState(ReportStateEnum state,Pageable pageable);
	
	Report changeReportState(Integer reportId, ReportStateEnum reportStateEnum) throws ReportException;
	
	Report createNewReport(Report report);
	
	void deleteReport(Integer reportId) throws ReportException;
}
