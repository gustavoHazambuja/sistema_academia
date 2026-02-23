package com.example.sistema_academia.application.dtos;

import java.time.LocalDate;

import com.example.sistema_academia.domain.enums.EnumPlano;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {
    
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private LocalDate dataMatricula;
    private EnumPlano planoAcademia;

}
