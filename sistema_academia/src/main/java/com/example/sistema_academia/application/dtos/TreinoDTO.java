package com.example.sistema_academia.application.dtos;

import java.time.LocalDate;

import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.domain.entities.Instrutor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TreinoDTO {
    
    private Aluno aluno;
    private Instrutor instrutor;
    private String objetivo;
    private LocalDate datacriacao;

}
