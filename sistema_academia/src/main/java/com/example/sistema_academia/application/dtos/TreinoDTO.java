package com.example.sistema_academia.application.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TreinoDTO {
    
    @NotNull (message = "O cpf é obrigatório") @Size(min = 11, max = 11, message = "o CPF deve ter 11 caracteres")
    private String cpfAluno;

    @NotNull (message = "O cpf é obrigatório") @Size(min = 11, max = 11, message = "o CPF deve ter 11 caracteres")
    private String cpfInstrutor;

    @NotBlank(message = "O objetivo é obrigatório")
    private String objetivo;
    
    private LocalDate datacriacao = LocalDate.now();

}
