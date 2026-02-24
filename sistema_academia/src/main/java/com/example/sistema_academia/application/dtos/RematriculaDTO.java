package com.example.sistema_academia.application.dtos;

import java.time.LocalDate;

import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.domain.enums.EnumPlano;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RematriculaDTO {
    
    private Aluno aluno;
    private EnumPlano planoAcademia;
    private LocalDate dataRematricula;
}
