package com.example.sistema_academia.application.dtos;

import java.time.LocalDate;

import com.example.sistema_academia.domain.entities.Treino;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TreinoResumoDTO {
    
    private String nomeALuno;
    private String nomeInstrutor;
    private String objetivo;
    private LocalDate dataCriacao = LocalDate.now();



    public static TreinoResumoDTO fromModel(Treino treino){
        return new TreinoResumoDTO(
            treino.getNomeAluno(),
            treino.getNomeInstrutor(),
            treino.getObjetivo(),
            treino.getDataCriacao()
        );
    }
}



