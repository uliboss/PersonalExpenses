package com.info.personalexpensesapp.controller;

import com.info.personalexpensesapp.dto.ExpenseDto;
import com.info.personalexpensesapp.dto.TotalDto;
import com.info.personalexpensesapp.model.Expense;
import com.info.personalexpensesapp.service.ExpenseService;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ExpenseController {
    private final ExpenseService expenseService;
    private final ModelMapper modelMapper;

    public ExpenseController(ExpenseService expenseService, ModelMapper modelMapper) {
        this.expenseService = expenseService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/expenses")
    public ResponseEntity<ExpenseDto> createExpense(@Valid @RequestBody Expense expense){
        Expense result = expenseService.createExpense(expense);
        ExpenseDto expenseResponse = modelMapper.map(result, ExpenseDto.class);
        return new ResponseEntity<>(expenseResponse, HttpStatus.CREATED);
    }

    @GetMapping("/total")
    public TotalDto getTotalExpenses(@RequestParam String base) {
        return expenseService.getTotalExpenses(base);
    }

    @GetMapping("/expenses")
    public Map<Object, List<ExpenseDto>> getAllExpensesByDate() {
        return expenseService
                .getAllExpenses()
                .stream()
                .map(expense -> modelMapper.map(expense, ExpenseDto.class))
                .collect(Collectors.groupingBy(ExpenseDto::getDate, TreeMap::new, Collectors.toList()));
    }

    @DeleteMapping("/expenses")
    public List<Expense> deleteByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return expenseService.deleteByDate(date);

//      If you need DTO in return, uncomment the return statement that is below and comment the one that is above. Also change return type on List<ExpenseDto>.

//        return expenseService.deleteByDate(date)
//                .stream()
//                .map(expense -> modelMapper.map(expense, ExpenseDto.class))
//                .collect(Collectors.toList());
    }
}