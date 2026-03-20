package com.example.sistema_academia.application.dtos;

import java.math.BigDecimal;

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
public class FinanceiroDTO {
    
    @NotNull(message = "O valor é obrigatório")
    private BigDecimal valor;

    @NotBlank(message = "O CPF é obrigatório") @Size(min = 11, max = 11, message = "o CPF deve ter 11 caracteres")
    private String cpfAluno;
}
