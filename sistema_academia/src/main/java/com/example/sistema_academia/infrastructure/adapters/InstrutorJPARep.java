package com.example.sistema_academia.infrastructure.adapters;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema_academia.domain.entities.Instrutor;

public interface InstrutorJPARep extends JpaRepository<Instrutor, Integer> {
    
    Instrutor findInstrutorIgnoringCaseContainingByNome(String nome);
    boolean existsById(int id);
    boolean existsIgnoringCaseContainingByNome(String nome);
}
