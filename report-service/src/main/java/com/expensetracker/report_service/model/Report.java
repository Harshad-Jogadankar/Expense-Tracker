package com.expensetracker.report_service.model;

import java.util.Map;

public class Report {
    private Double totalAmount;
    private Map<String, Double> categoryBreakdown;

    // Getters and setters
    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Map<String, Double> getCategoryBreakdown() {
        return categoryBreakdown;
    }

    public void setCategoryBreakdown(Map<String, Double> categoryBreakdown) {
        this.categoryBreakdown = categoryBreakdown;
    }
}
