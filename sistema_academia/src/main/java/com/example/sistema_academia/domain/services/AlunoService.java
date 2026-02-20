package com.example.sistema_academia.domain.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.sistema_academia.domain.contracts.AlunoContract;
import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.domain.entities.Rematricula;

@Service
public class AlunoService{
    
    @Autowired
    private AlunoContract alunoContract;

    public boolean validarCPFAluno(String cpf){
        return alunoContract.validarCPFAluno(cpf);
    }

    public boolean cadastrarAluno(Aluno aluno){
        if(validarCPFAluno(aluno.getCpf())){
            return true;
        }
        return false;
    }

    public boolean validarIdAluno(int id){
        return alunoContract.validarIdAluno(id);
    }

    public boolean fazerRematricula(Rematricula rematricula){
        if(validarCPFAluno(rematricula.getAluno().getCpf())){
            return true;
        }
        return false;
    }

    public Page<Aluno> listarAlunos(Pageable pageable){
       return alunoContract.listarAlunos(pageable);
    }

    public boolean deletarAluno(int id){
        if(validarIdAluno(id)){
            return true;
        }
        return false;
    }
}
