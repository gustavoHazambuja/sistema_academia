package com.example.sistema_academia.domain.contracts;

import java.util.List;
import java.util.Optional;

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
    void deletarAlunoPorId(int id);
    Optional<Aluno> buscarAlunoPorCpf(String cpf);
    List<Aluno> buscarAlunoPorNome(String nome);
}
