package com.info.personalexpensesapp.service;

import com.info.personalexpensesapp.dto.TotalDto;
import com.info.personalexpensesapp.model.Expense;
import java.time.LocalDate;
import java.util.List;

public interface ExpenseService {
    Expense createExpense(Expense expense);
    List<Expense> getAllExpenses();
    List<Expense> deleteByDate(LocalDate date);
    TotalDto getTotalExpenses(String base);
}
