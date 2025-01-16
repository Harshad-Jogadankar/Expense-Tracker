package com.expensetracker.report_service.service;

import com.expensetracker.report_service.model.Expense;
import com.expensetracker.report_service.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReportService {

    private static final String EXPENSE_SERVICE_URL = "http://localhost:8081/api1/expense/user/";



    @Autowired
    private RestTemplate restTemplate;

    public Report generateReportForUser(Long userId) {
        // Fetch expenses from expense-service
        Expense[] expenses = restTemplate.getForObject(EXPENSE_SERVICE_URL + userId, Expense[].class);

        if (expenses == null || expenses.length == 0) {
            throw new RuntimeException("No expenses found for user ID: " + userId);
        }

        // Calculate total amount and category breakdown
        double totalAmount = 0.0;
        Map<String, Double> categoryBreakdown = new HashMap<>();

        for (Expense expense : expenses) {
            totalAmount += expense.getAmount();

            categoryBreakdown.put(
                    expense.getCategory(),
                    categoryBreakdown.getOrDefault(expense.getCategory(), 0.0) + expense.getAmount()
            );
        }

        // Create the report
        Report report = new Report();
        report.setTotalAmount(totalAmount);
        report.setCategoryBreakdown(categoryBreakdown);

        return report;
    }
}
