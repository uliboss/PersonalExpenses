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
        Expense expense = new Expense(LocalDate.of(2018,2,5), 5.5, "EUR", "Milk");
        expenseRepository.save(expense);
        log.info("New purchase is done: " + expense);

        Expense expense2 = new Expense(LocalDate.of(2016,5,2), 5, "EUR", "Cheese");
        expenseRepository.save(expense2);
        log.info("New purchase is done: " + expense2);

        Expense expense3 = new Expense(LocalDate.of(2016,5,2), 400, "EUR", "Bread");
        expenseRepository.save(expense3);
        log.info("New purchase is done: " + expense3);
    }
}
