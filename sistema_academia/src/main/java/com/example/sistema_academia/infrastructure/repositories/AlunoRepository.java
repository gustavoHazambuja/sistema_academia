package com.example.sistema_academia.infrastructure.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.sistema_academia.domain.contracts.AlunoContract;
import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.domain.entities.Rematricula;
import com.example.sistema_academia.infrastructure.adapters.AlunoJPARep;
import com.example.sistema_academia.infrastructure.adapters.RematriculaJPARep;

@Repository
public class AlunoRepository implements AlunoContract {
    

    @Autowired
    private AlunoJPARep alunoJPARepjpaRep;

    @Autowired
    private RematriculaJPARep rematriculaJPARep;


    @Override
    public boolean cadastrarAluno(Aluno aluno){
        if(aluno == null){
            return false;
        }

        return alunoJPARepjpaRep.save(aluno) != null;
    }

    @Override
    public boolean validarCPFAluno(String cpf){
        return alunoJPARepjpaRep.existsByCpf(cpf);
    }

    @Override
    public boolean validarIdAluno(int id){
        return alunoJPARepjpaRep.existsById(id);
    }

    @Override
    public boolean fazerRematricula(Rematricula rematricula){
        if(rematricula == null){
            return false;
        }

        return rematriculaJPARep.save(rematricula) != null;
    }

    @Override
    public Page<Aluno> listarAlunos(Pageable pageable){
        return alunoJPARepjpaRep.findAll(pageable);
    }

    @Override
    public boolean deletarAlunoPorId(int id){
        return alunoJPARepjpaRep.deleteAlunoById(id);
    }

    @Override
    public Optional<Aluno> buscarAlunoPorCpf(String cpf){
        return alunoJPARepjpaRep.findAlunoByCpf(cpf);
    }

    @Override
    public Optional<Aluno> buscarAlunoPorNome(String nome){
        return alunoJPARepjpaRep.findAlunoIgnoringCaseContainingByNome(nome);
    }
}
