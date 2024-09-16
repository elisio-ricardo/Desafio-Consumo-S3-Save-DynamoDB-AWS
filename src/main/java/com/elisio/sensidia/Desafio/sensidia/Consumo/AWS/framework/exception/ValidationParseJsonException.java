package com.elisio.sensidia.Desafio.sensidia.Consumo.AWS.framework.exception;


import lombok.Data;

@Data
public class ValidationParseJsonException extends RuntimeException {

    private String error;
    public ValidationParseJsonException(String message) {
        this.error = message;
    }
}
