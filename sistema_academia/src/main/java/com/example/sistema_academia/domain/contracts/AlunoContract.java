package com.example.sistema_academia.domain.contracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.domain.entities.Rematricula;


public interface AlunoContract {
    
    boolean cadastrarAluno(Aluno aluno);
    boolean validarCPFAluno(String cpf);
    boolean validarIdAluno(int id);
    boolean fazerRematricula(Rematricula rematricula);
    Page<Aluno> listarAlunos(Pageable pageable);
    boolean deletarAluno(int id);
}
