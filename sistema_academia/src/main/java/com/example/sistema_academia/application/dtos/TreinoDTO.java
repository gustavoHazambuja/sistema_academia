package com.example.sistema_academia.application.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TreinoDTO {
    
    private String nomeALuno;
    private String nomeInstrutor;
    private String objetivo;
    private LocalDate datacriacao = LocalDate.now();

}
