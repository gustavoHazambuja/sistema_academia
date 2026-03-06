package com.example.sistema_academia.application.dtos;

import java.time.LocalDate;

import com.example.sistema_academia.domain.enums.EnumPlano;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RematriculaDTO {
    
    @NotBlank (message = "O CPF é obrigatório") @Column(unique = true)
    private String cpf;

    @NotNull(message = "O plano é obrigatório")
    private EnumPlano planoAcademia;

    private LocalDate dataRematricula = LocalDate.now();
}
