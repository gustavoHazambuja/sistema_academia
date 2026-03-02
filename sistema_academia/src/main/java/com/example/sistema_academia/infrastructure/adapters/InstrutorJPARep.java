package com.example.sistema_academia.infrastructure.adapters;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema_academia.domain.entities.Instrutor;

public interface InstrutorJPARep extends JpaRepository<Instrutor, Integer> {
    
    Optional<Instrutor> findInstrutorIgnoringCaseContainingByNome(String nome);
    boolean existsById(int id);
    boolean existsByCpf(String cpf);
    boolean existsIgnoringCaseContainingByNome(String nome);
}
