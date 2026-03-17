package com.example.sistema_academia.infrastructure.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema_academia.domain.entities.Instrutor;

public interface InstrutorJPARep extends JpaRepository<Instrutor, Long> {
    
    List<Instrutor> findByNomeContainingIgnoreCase(String nome);
    boolean existsById(Long id);
    boolean existsByCpf(String cpf);
    boolean existsIgnoringCaseByNome(String nome);
    Optional<Instrutor> findByCpf(String cpf);
}
