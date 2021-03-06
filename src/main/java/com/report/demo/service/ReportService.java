package com.report.demo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.report.demo.domain.Report;
import com.report.demo.dto.ReportDto;
import com.report.demo.reportEnum.ReportException;
import com.report.demo.reportEnum.ReportStateEnum;
import com.report.demo.response.PagingResponse;

public interface ReportService {
	List<ReportDto> finalAllReports();
	
	PagingResponse findReportsByState(ReportStateEnum state,Pageable pageable);
	
	Report changeReportState(Integer reportId, ReportStateEnum reportStateEnum) throws ReportException;
	
	ReportDto createNewReport(Report report);
	
	List<Report> creatListOfNewReport(List<Report> reports);
	
	void deleteReport(Integer reportId) throws ReportException;
}
