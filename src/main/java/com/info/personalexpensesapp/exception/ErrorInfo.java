package com.info.personalexpensesapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Date;

@AllArgsConstructor
@Getter
public class ErrorInfo {
    private final Date timestamp;
    private final String message;
    private final String details;
}
