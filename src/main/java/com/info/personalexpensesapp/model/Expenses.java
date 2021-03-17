package com.info.personalexpensesapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date date;
    private double amount;
    private String currency;
    private String product;
    private double total;

    public Expenses(Date date, double amount, String currency, String product) {
        this.date = date;
        this.amount = amount;
        this.currency = currency;
        this.product = product;
    }
}
