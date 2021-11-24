package com.report.demo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.report.demo.domain.Report;
import com.report.demo.reportEnum.ReportStateEnum;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
	Optional<Page<Report>> findByState(ReportStateEnum state, Pageable pageable);
}
