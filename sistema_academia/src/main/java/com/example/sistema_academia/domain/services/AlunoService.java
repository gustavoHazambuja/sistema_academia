package com.example.sistema_academia.domain.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sistema_academia.domain.contracts.AlunoContract;
import com.example.sistema_academia.domain.entities.Aluno;

@Service
@Transactional
public class AlunoService{
    
    @Autowired
    private AlunoContract alunoContract;

    public boolean validarCPFAluno(String cpf){
        return alunoContract.validarCPFAluno(cpf);
    }

    public boolean cadastrarAluno(Aluno aluno){
        
        if(aluno == null){
            return false;
        }

        boolean cpfJaExiste = validarCPFAluno(aluno.getCpf());
        
        if(cpfJaExiste){
            return false;
        }

        return alunoContract.cadastrarAluno(aluno);
    }

    public boolean validarIdAluno(int id){
        return alunoContract.validarIdAluno(id);
    }

    public Page<Aluno> listarAlunos(Pageable pageable){
       return alunoContract.listarAlunos(pageable);
    }

    public void deletarAlunoPorId(int id){

        alunoContract.deletarAlunoPorId(id);
    }

    public Optional<Aluno> buscarAlunoPorCpf(String cpf){
        return alunoContract.buscarAlunoPorCpf(cpf);
    }

    public List<Aluno> buscarAlunoPorNome(String nome){
        return alunoContract.buscarAlunoPorNome(nome);
    }

    public Optional<Aluno> buscarAlunoPorId(int id){
        return alunoContract.buscarAlunoPorId(id);
    }

    public boolean atualizarAluno(Aluno aluno){
        return alunoContract.atualizarAluno(aluno);
    }
}
