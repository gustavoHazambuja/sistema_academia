package com.example.sistema_academia.application.dtos;

import java.time.LocalDate;

import com.example.sistema_academia.domain.enums.EnumPlano;

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
public class RematriculaDTO {

    @NotBlank(message = "O CPF é obrigatório") @Size(min = 11, max = 11, message = "O CPF precisa ter 11 caracteres.")
    private String cpfAluno;
    
    @NotNull (message = "O ID é obrigatório")
    private Integer aluno_id;

    @NotNull(message = "O plano é obrigatório")
    private EnumPlano planoAcademia;

    private LocalDate dataRematricula = LocalDate.now();
}
