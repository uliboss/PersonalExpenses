package com.info.personalexpensesapp.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDto {

    private LocalDate date;
    private double amount;
    private String currency;
    private String product;
}
