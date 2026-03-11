package com.example.sistema_academia.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.sistema_academia.domain.contracts.AlunoContract;
import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.infrastructure.adapters.AlunoJPARep;

@Repository
public class AlunoRepository implements AlunoContract {
    

    @Autowired
    private AlunoJPARep alunoJPARep;


    @Override
    public boolean cadastrarAluno(Aluno aluno){
        if(aluno == null){
            return false;
        }

        return alunoJPARep.save(aluno) != null;
    }

    @Override
    public boolean validarCPFAluno(String cpf){
        return alunoJPARep.existsByCpf(cpf);
    }

    @Override
    public boolean validarIdAluno(int id){
        return alunoJPARep.existsById(id);
    }

    @Override
    public Page<Aluno> listarAlunos(Pageable pageable){
        return alunoJPARep.findAll(pageable);
    }

    @Override
    public void deletarAlunoPorId(int id){
        alunoJPARep.deleteById(id);
    }

    @Override
    public Optional<Aluno> buscarAlunoPorCpf(String cpf){
        return alunoJPARep.findAlunoByCpf(cpf);
    }

    @Override
    public List<Aluno> buscarAlunoPorNome(String nome){
        return alunoJPARep.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public Optional<Aluno> buscarAlunoPorId(int id){
        return alunoJPARep.findById(id);
    }

    @Override
    public boolean atualizarAluno(Aluno aluno){
        if(aluno == null){
            return false;
        }

        return alunoJPARep.save(aluno) != null;
    }
}
