package com.elisio.sensidia.Desafio.sensidia.Consumo.AWS.framework.exception;


import lombok.Data;

@Data
public class UploadException {
    private String message;

    public UploadException(String message) {
        this.message = message;
    }
}