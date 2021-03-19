package com.info.personalexpensesapp;

import com.info.personalexpensesapp.model.Expense;
import com.info.personalexpensesapp.repository.ExpenseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;

@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {

    private final ExpenseRepository expenseRepository;

    public Application(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        Expense testExpense = new Expense(LocalDate.of(2018,2,5), 3, "EUR", "Milk");
        expenseRepository.save(testExpense);
        log.info("New purchase is done: " + testExpense);

        Expense testExpense2 = new Expense(LocalDate.of(2016,5,2), 5, "EUR", "Cheese");
        expenseRepository.save(testExpense2);
        log.info("New purchase is done: " + testExpense2);

        Expense testExpense3 = new Expense(LocalDate.of(2016,5,2), 1, "EUR", "Bread");
        expenseRepository.save(testExpense3);
        log.info("New purchase is done: " + testExpense3);
    }
}
