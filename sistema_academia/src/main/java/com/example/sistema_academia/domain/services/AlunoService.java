package com.example.sistema_academia.domain.services;


import java.time.LocalDate;

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
       
        Aluno aluno = buscarAlunoPorCpf(rematricula.getCpf());

         if (aluno == null) {
            return false;
        }

        rematricula.setDataRematricula(LocalDate.now());


        return alunoContract.fazerRematricula(rematricula);

    }

    public Page<Aluno> listarAlunos(Pageable pageable){
       return alunoContract.listarAlunos(pageable);
    }

    public boolean deletarAlunoPorId(int id){
        if(validarIdAluno(id)){
            return true;
        }
        return false;
    }

    public Aluno buscarAlunoPorCpf(String cpf){
        return alunoContract.buscarAlunoPorCpf(cpf);
    }

    public Aluno buscarAlunoPorNome(String nome){
        return alunoContract.buscarAlunoPorNome(nome);
    }
}
