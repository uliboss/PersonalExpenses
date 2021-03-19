package com.info.personalexpensesapp.service;

import com.info.personalexpensesapp.dto.RateDto;
import com.info.personalexpensesapp.dto.TotalDto;
import com.info.personalexpensesapp.model.Expense;
import com.info.personalexpensesapp.repository.ExpenseRepository;
import com.info.personalexpensesapp.util.CurrencyUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final RestTemplate restTemplate;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository, RestTemplate restTemplate) {
        this.expenseRepository = expenseRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    @Transactional
    public List<Expense> deleteByDate(LocalDate date) {
        List<Expense> allByDate = expenseRepository.findAllByDate(date);
        expenseRepository.deleteAll(allByDate);
        return allByDate;
    }

    @Override
    public TotalDto getTotalExpenses(String base) {
        if (!CurrencyUtils.containsCurrencyCode(base)) {
            throw new IllegalArgumentException("Invalid currency");
        }
        double total = Double.parseDouble(CurrencyUtils.customCurrencyDecimalDotFormat()
                .format(expenseRepository.findAll().stream()
                        .map(entry -> calculateSumOfConvertedExpenses(entry, base))
                        .reduce(0., Double::sum)));

        return new TotalDto(total, base);
    }

    private Double calculateSumOfConvertedExpenses(Expense expense, String base) {
        Double expenseCurrencyRate = restTemplate.getForObject(String.format("https://api.exchangerate.host/%s?symbols=%s&base=%s",
                expense.getDate(), String.join(".", expense.getCurrency()), base), RateDto.class).getRates().get(expense.getCurrency());
        return expense.getAmount() / expenseCurrencyRate;
    }
}


