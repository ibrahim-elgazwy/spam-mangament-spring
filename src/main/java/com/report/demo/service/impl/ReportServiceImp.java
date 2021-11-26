package com.report.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.report.demo.domain.Report;
import com.report.demo.dto.ReportDto;
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
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	@Transactional(readOnly = true)
	public List<ReportDto> finalAllReports() {
		List<Report> reports = reportRepository.findAll();
		List<ReportDto> reportDtos =   reports.stream()
					.map(report -> modelMapper.map(report, ReportDto.class))
					.collect(Collectors.toList());
		
		return reportDtos;
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
	public ReportDto createNewReport(Report report) {
		Report newReport = reportRepository.save(report);
		ReportDto reportDto = modelMapper.map(newReport, ReportDto.class);
		return reportDto;
	}

	@Override
	@Transactional(readOnly = true)
	public PagingResponse findReportsByState(ReportStateEnum state, Pageable pageable) {
		Page<Report> reports = reportRepository
				.findByState(state, pageable)
				.orElse(null);
		
		List<ReportDto> reportDtos =   reports.getContent().stream()
				.map(report -> modelMapper.map(report, ReportDto.class))
				.collect(Collectors.toList());
		
		return new PagingResponse(reports, reportDtos);
	}

	@Override
	public void deleteReport(Integer reportId) throws ReportException {
		Report report = reportRepository
				.findById(reportId)
				.orElseThrow(() -> new ReportException(ErrorCodeEnum.NOT_FOIND_REQUEST_ID));
		
		reportRepository.deleteById(report.getId());
	}

	@Override
	public List<Report> creatListOfNewReport(List<Report> reports) {
		List<Report> newReports = reportRepository.saveAll(reports);
		return newReports;
	}
}
