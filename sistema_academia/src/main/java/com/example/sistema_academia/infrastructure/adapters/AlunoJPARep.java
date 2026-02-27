package com.example.sistema_academia.infrastructure.adapters;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema_academia.domain.entities.Aluno;


public interface AlunoJPARep extends JpaRepository<Aluno, Integer> {
    
    boolean deleteAlunoById(int id);
    boolean existsById(int id);
    boolean existsByCpf(String cpf);
    Optional<Aluno> findAlunoByCpf(String cpf);
    Optional<Aluno> findAlunoIgnoringCaseContainingByNome(String nome);
}
