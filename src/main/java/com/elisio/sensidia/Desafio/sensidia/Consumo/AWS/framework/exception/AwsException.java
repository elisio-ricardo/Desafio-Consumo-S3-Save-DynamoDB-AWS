package com.elisio.sensidia.Desafio.sensidia.Consumo.AWS.framework.exception;


import lombok.Data;

@Data
public class AwsException extends RuntimeException {
    private String error;

    public AwsException(String message) {
        this.error = message;
    }

    public String getError() {
        return error;
    }

}