package com.example.sistema_academia.domain.contracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.domain.enums.EnumPlano;


public interface AlunoContract {
    
    boolean cadastrarAluno(Aluno aluno);
    boolean validarCPFAluno(String cpf);
    boolean validarIdAluno(Long id);
    Page<Aluno> listarAlunos(Pageable pageable);
    void deletarAlunoPorId(Long id);
    Optional<Aluno> buscarAlunoPorCpf(String cpf);
    Optional<Aluno> buscarAlunoPorId(Long id);
    List<Aluno> buscarAlunoPorNome(String nome);
    boolean atualizarAluno(Aluno aluno);
    List<Aluno> buscarAlunoPorPlano(EnumPlano planoAcademia);
}
