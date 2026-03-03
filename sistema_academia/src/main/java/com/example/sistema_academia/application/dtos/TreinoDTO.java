package com.example.sistema_academia.application.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TreinoDTO {
    
    @NotBlank(message = "O nome do aluno é obrigatório")
    private String nomeALuno;

    @NotBlank(message = "O nome do instrutor é obrigatório")
    private String nomeInstrutor;

    @NotBlank(message = "O objetivo é obrigatório")
    private String objetivo;
    
    private LocalDate datacriacao = LocalDate.now();

}
