package com.report.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.report.demo.domain.Report;
import com.report.demo.reportEnum.ErrorCodeEnum;
import com.report.demo.reportEnum.ReportException;
import com.report.demo.reportEnum.ReportStateEnum;
import com.report.demo.repository.ReportRepository;
import com.report.demo.response.PagingResponse;
import com.report.demo.service.ReportService;

@Service
public class ReportServiceImp implements ReportService {

	@Autowired
	private ReportRepository reportRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Report> finalAllReports() {
		List<Report> reports = reportRepository.findAll();
		return reports;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Report changeReportState(Integer id, ReportStateEnum reportStateEnum) throws ReportException {
		Report report = reportRepository
				.findById(id)
				.orElseThrow(() -> new ReportException(ErrorCodeEnum.NOT_FOIND_REQUEST_ID));
		
		report.setState(reportStateEnum);
		report = reportRepository.save(report);
		return report;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Report createNewReport(Report report) {
		Report newReport = reportRepository.save(report);
		return newReport;
	}

	@Override
	@Transactional(readOnly = true)
	public PagingResponse findReportsByState(ReportStateEnum state, Pageable pageable) {
		Page<Report> reports = reportRepository
				.findByState(state, pageable)
				.orElse(null);
		
		return new PagingResponse(reports, reports.getContent());
	}

	@Override
	public void deleteReport(Integer reportId) throws ReportException {
		Report report = reportRepository
				.findById(reportId)
				.orElseThrow(() -> new ReportException(ErrorCodeEnum.NOT_FOIND_REQUEST_ID));
		
		reportRepository.deleteById(report.getId());
	}
}
