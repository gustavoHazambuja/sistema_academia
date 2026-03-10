package com.example.sistema_academia.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sistema_academia.application.dtos.RematriculaDTO;
import com.example.sistema_academia.application.dtos.RematriculaResumoDTO;
import com.example.sistema_academia.domain.entities.Rematricula;
import com.example.sistema_academia.domain.services.RematriculaService;

@Component
public class RematriculaUC {
    
    @Autowired
    private RematriculaService rematriculaService;


    public boolean fazerRematricula(RematriculaDTO dto){

        Rematricula rematricula = toModel(dto);
        return rematriculaService.fazerRematricula(rematricula);
    }

    public List<RematriculaResumoDTO> buscarHistorico(String cpfAluno){
        List<Rematricula> rematriculas = rematriculaService.buscarHistorico(cpfAluno);

            return rematriculas.stream()
                .map(RematriculaResumoDTO::fromModel)
                .toList();
    }



    private Rematricula toModel(RematriculaDTO dto){
        return new Rematricula(
            dto.getCpfAluno(),
            dto.getAluno_id(),
            dto.getPlanoAcademia(),
            dto.getDataRematricula()
        );
    }
}
