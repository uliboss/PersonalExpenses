package com.info.personalexpensesapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@ToString
@NoArgsConstructor
@Getter
@Setter
public class RateDto {

    private String base;
    private LocalDate date;
    private Map<String, Double> rates = new HashMap<>();
}
