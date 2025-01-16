package com.expensetracker.expense_service.service;

import com.expensetracker.expense_service.model.Expense;
import com.expensetracker.expense_service.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense createExpense(Long userId, Expense expense) {
        expense.setUserId(userId); // Link expense to the user
        return expenseRepository.save(expense);
    }

    public List<Expense> getExpensesByUserId(Long userId) {
        return expenseRepository.findByUserId(userId);
    }

    public void deleteExpense(Long expenseId) {
        expenseRepository.deleteById(expenseId);
    }

    public Expense updateExpense(Long expenseId, Expense updatedExpense) {
        return expenseRepository.findById(expenseId)
                .map(existingExpense -> {
                    existingExpense.setCategory(updatedExpense.getCategory());
                    existingExpense.setAmount(updatedExpense.getAmount());
                    return expenseRepository.save(existingExpense);
                })
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + expenseId));
    }
}
