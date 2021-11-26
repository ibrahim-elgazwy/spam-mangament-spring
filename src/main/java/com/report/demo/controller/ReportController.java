package com.report.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.report.demo.domain.Report;
import com.report.demo.reportEnum.ReportException;
import com.report.demo.reportEnum.ReportStateEnum;
import com.report.demo.requests.UpdateReportRequest;
import com.report.demo.response.PagingResponse;
import com.report.demo.response.RestResponse;
import com.report.demo.service.ReportService;
import com.report.demo.validators.ValidateReportUpdateRequest;

@RestController
@RequestMapping("/reports")
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	@Autowired
	private ValidateReportUpdateRequest validateReportUpdateRequest;

	@InitBinder("updateReportRequest")
	private void correctSakUserControllerInitBinder(WebDataBinder binder) {
		binder.setValidator(validateReportUpdateRequest);
	}
	
	@PutMapping("/{reportId}")
	public RestResponse updateReportState( 
			@PathVariable("reportId") Integer reportId,
			@Validated @RequestBody UpdateReportRequest updateReportRequest) throws ReportException {
		
		ReportStateEnum reportState = ReportStateEnum.getReportEnum(updateReportRequest.getTicketState());
		
		Report report = reportService.changeReportState(reportId, reportState);
		
		return new RestResponse(report);	
	}
	
	@GetMapping()
	public RestResponse getReports() {
		List<Report> reports = reportService.finalAllReports();
		return new RestResponse(reports);
	}
	
	@GetMapping("/{state}")
	public RestResponse getReportsByState(
			 @RequestParam(defaultValue = "0") int page,
		     @RequestParam(defaultValue = "5") int size,
		     @RequestParam(defaultValue = "id") String[] sort,
			@PathVariable("state") ReportStateEnum state) {
		
		Pageable pagingSort = PageRequest.of(page, size, Sort.by(sort));
		
		PagingResponse reports = reportService.findReportsByState(state, pagingSort);
		return new RestResponse(reports);
	}
	
	@PostMapping()
	public RestResponse createNewReport(@RequestBody Report report) {
		Report savedReport = reportService.createNewReport(report);
		return new RestResponse(savedReport);
	}
	
	@PostMapping("/addListOfNewReports")
	public RestResponse createNewReports(@RequestBody List<Report> reports) {
		List<Report>  savedReports = reportService.creatListOfNewReport(reports);
		return new RestResponse(savedReports);
	}
	
	@DeleteMapping("/{reportId}")
	public RestResponse blockReport(@PathVariable Integer reportId) throws ReportException {
		reportService.deleteReport(reportId);
		String blockReportMsg = new String("Report are blocked !");
		return new RestResponse(blockReportMsg);
	}
}
