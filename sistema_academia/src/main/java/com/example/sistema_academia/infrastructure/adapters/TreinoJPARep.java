package com.example.sistema_academia.infrastructure.adapters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema_academia.domain.entities.Treino;

public interface TreinoJPARep extends JpaRepository<Treino, Integer> {
    
    List<Treino> findByCpfAluno(String cpf);
}
