package com.example.sistema_academia.domain.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistema_academia.domain.contracts.RematriculaContract;
import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.domain.entities.Rematricula;

@Service
public class RematriculaService {
    
    @Autowired
    private RematriculaContract rematriculaContract;

    @Autowired
    private AlunoService alunoService;


    public boolean fazerRematricula(Rematricula rematricula){

        Optional<Aluno> aluno =  alunoService.buscarAlunoPorCpf(rematricula.getCpfAluno());

        if(aluno == null){
            return false;
        }

        rematricula.setPlanoAcademia(rematricula.getPlanoAcademia());
        rematricula.setDataRematricula(LocalDate.now());

        return rematriculaContract.fazerRematricula(rematricula);
    }

    public List<Rematricula> buscarHistorico(String cpfAluno){
        return rematriculaContract.buscarHistorico(cpfAluno);
    }
}
