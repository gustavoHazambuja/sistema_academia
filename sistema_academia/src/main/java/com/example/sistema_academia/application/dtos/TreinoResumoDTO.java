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
    
    private Long id;
    private String cpfALuno;
    private String cpfInstrutor;
    private String objetivo;
    private LocalDate dataCriacao = LocalDate.now();



    public static TreinoResumoDTO fromModel(Treino treino){
        return new TreinoResumoDTO(
            treino.getId(),
            treino.getAluno() != null ? treino.getAluno().getCpf() : treino.getCpfAluno(),
            treino.getInstrutor() != null ? treino.getInstrutor().getCpf() : treino.getCpfInstrutor(),
            treino.getObjetivoAluno(),
            treino.getDataCriacao()
        );
    }
}
