package com.example.sistema_academia.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sistema_academia.application.dtos.TreinoDTO;
import com.example.sistema_academia.application.dtos.TreinoResumoDTO;
import com.example.sistema_academia.domain.entities.Treino;
import com.example.sistema_academia.domain.services.TreinoService;

@Component
public class TreinoUC {
    
    @Autowired
    private TreinoService treinoService;


    public boolean criarTreino(TreinoDTO dto){

        Treino treino = toModel(dto);
        return treinoService.criarTreino(treino);
    }

    public List<TreinoResumoDTO> buscarHistoricoTreinos(String cpfAluno){

        List<Treino> treinos = treinoService.buscarHistoricoTreinos(cpfAluno);
        
            return treinos.stream()
                .map(TreinoResumoDTO::fromModel)
                .toList();
    }

    private Treino toModel(TreinoDTO dto){
        return new Treino(
            dto.getCpfAluno(),
            dto.getCpfInstrutor(),
            dto.getObjetivoAluno(),
            dto.getDatacriacao()
        );
    }
}
