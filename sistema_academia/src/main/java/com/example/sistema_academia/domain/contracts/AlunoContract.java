package com.example.sistema_academia.domain.contracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.sistema_academia.domain.entities.Aluno;


public interface AlunoContract {
    
    boolean cadastrarAluno(Aluno aluno);
    boolean validarCPFAluno(String cpf);
    boolean validarIdAluno(int id);
    Page<Aluno> listarAlunos(Pageable pageable);
    void deletarAlunoPorId(int id);
    Optional<Aluno> buscarAlunoPorCpf(String cpf);
    Optional<Aluno> buscarAlunoPorId(int id);
    List<Aluno> buscarAlunoPorNome(String nome);
    boolean atualizarAluno(Aluno aluno);
}
