package com.example.sistema_academia.infrastructure.adapters;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema_academia.domain.entities.Aluno;


public interface AlunoJPARep extends JpaRepository<Aluno, Integer> {
    
    boolean deleteAlunoById(int id);
    boolean existsById(int id);
    boolean existsByCpf(String cpf);
    Aluno findAlunoByCpf(String cpf);
    Aluno findAlunoIgnoringCaseContainingByNome(String nome);
}
