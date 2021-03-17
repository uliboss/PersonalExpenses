package com.info.personalexpensesapp.controller;

import com.info.personalexpensesapp.service.ExpenseServices;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {
    private final ExpenseServices expenseServices;
    private final ModelMapper modelMapper;

    public ExpenseController(ExpenseServices expenseServices, ModelMapper modelMapper) {
        this.expenseServices = expenseServices;
        this.modelMapper = modelMapper;
    }

}
