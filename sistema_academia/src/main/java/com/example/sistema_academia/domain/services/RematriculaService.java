package com.example.sistema_academia.domain.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sistema_academia.domain.contracts.RematriculaContract;
import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.domain.entities.Rematricula;

@Service
@Transactional
public class RematriculaService {
    
    @Autowired
    private RematriculaContract rematriculaContract;

    @Autowired
    private AlunoService alunoService;


    public boolean fazerRematricula(Rematricula rematricula){

        if(rematricula == null){
            return false;
        }

        Optional<Aluno> aluno =  alunoService.buscarAlunoPorCpf(rematricula.getCpfAluno());

        if(aluno.isEmpty()){
            return false;
        }


        rematricula.setDataRematricula(LocalDate.now());

        // Salvar rematrícula primeiro
        boolean rematriculaSalva = rematriculaContract.fazerRematricula(rematricula);
        
        if(!rematriculaSalva){
            return false;
        }

        // Atualizar o plano do aluno após confirmação da rematrícula
        Aluno alunoAtualizado = aluno.get();
        alunoAtualizado.setPlanoAcademia(rematricula.getPlanoAcademia());
        
        return alunoService.atualizarAluno(alunoAtualizado);
    }

    public List<Rematricula> buscarHistoricoRematriculas(String cpfAluno){
        return rematriculaContract.buscarHistoricoRematriculas(cpfAluno);
    }
}
