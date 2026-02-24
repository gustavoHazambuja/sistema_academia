package com.example.sistema_academia.application.dtos;

import java.time.LocalDate;

import com.example.sistema_academia.domain.enums.EnumTurno;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstrutorDTO {
    

    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private String formacao;
    private EnumTurno turnoAula;
}
