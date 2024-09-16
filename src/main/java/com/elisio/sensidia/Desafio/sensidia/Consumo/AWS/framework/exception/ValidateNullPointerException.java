package com.elisio.sensidia.Desafio.sensidia.Consumo.AWS.framework.exception;


import lombok.Data;

@Data
public class ValidateNullPointerException extends RuntimeException {

    private String error;

    public ValidateNullPointerException(String message) {
        this.error = message;
    }


}