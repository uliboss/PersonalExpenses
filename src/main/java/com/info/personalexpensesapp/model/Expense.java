package com.info.personalexpensesapp.model;

import com.info.personalexpensesapp.validation.IsValidCurrency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate date;

    @Min(value = 0L, message = "The value must be positive")
    private double amount;

    @NotBlank(message = "Currency is mandatory")
    @IsValidCurrency
    private String currency;
    private String product;

    public Expense(LocalDate date, double amount, String currency, String product) {
        this.date = date;
        this.amount = amount;
        this.currency = currency;
        this.product = product;
    }
}
