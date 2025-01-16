package com.expensetracker.report_service.controller;

import com.expensetracker.report_service.model.Report;
import com.expensetracker.report_service.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<Report> generateReport(@PathVariable Long userId) {
        Report report = reportService.generateReportForUser(userId);
        return ResponseEntity.ok(report);
    }
}
