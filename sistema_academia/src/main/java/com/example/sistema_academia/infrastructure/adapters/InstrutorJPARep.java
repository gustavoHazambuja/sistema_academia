package com.example.sistema_academia.infrastructure.adapters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema_academia.domain.entities.Instrutor;

public interface InstrutorJPARep extends JpaRepository<Instrutor, Integer> {
    
    List<Instrutor> findByNomeContainingIgnoreCase(String nome);
    boolean existsById(int id);
    boolean existsByCpf(String cpf);
    boolean existsIgnoringCaseByNome(String nome);
}
