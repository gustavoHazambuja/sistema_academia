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
    
    private Integer id;
    private Integer aluno_id;
    private Integer instrutor_id;
    private String objetivo;
    private LocalDate dataCriacao = LocalDate.now();



    public static TreinoResumoDTO fromModel(Treino treino){
        return new TreinoResumoDTO(
            treino.getId(),
            treino.getAluno_id(),
            treino.getInstrutor_id(),
            treino.getObjetivo(),
            treino.getDataCriacao()
        );
    }
}



