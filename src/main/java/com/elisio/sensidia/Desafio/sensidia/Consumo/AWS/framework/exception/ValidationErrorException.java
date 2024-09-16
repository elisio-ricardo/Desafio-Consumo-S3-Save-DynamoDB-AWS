package com.elisio.sensidia.Desafio.sensidia.Consumo.AWS.framework.exception;


import lombok.Data;

import java.util.List;

@Data
public class ValidationErrorException extends RuntimeException {
    private List<String> errors;

    public ValidationErrorException(List<String> errors) {
        this.errors = errors;
    }
}
