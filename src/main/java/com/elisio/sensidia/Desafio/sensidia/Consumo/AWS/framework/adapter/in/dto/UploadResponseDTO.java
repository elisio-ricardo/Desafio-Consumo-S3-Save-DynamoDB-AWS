package com.elisio.sensidia.Desafio.sensidia.Consumo.AWS.framework.adapter.in.dto;


import com.elisio.sensidia.Desafio.sensidia.Consumo.AWS.domain.entities.FileMetadata;
import com.elisio.sensidia.Desafio.sensidia.Consumo.AWS.domain.entities.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadResponseDTO {;

    @NotNull(message = "O Objeto User não pode ser null")
    @Valid
    private User user;

    @NotNull(message = "O Objeto file não pode ser null")
    @Valid
    private FileMetadata file;
}
