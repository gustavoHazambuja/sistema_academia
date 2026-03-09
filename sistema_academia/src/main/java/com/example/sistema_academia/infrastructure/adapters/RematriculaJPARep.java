package com.example.sistema_academia.infrastructure.adapters;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema_academia.domain.entities.Rematricula;

public interface RematriculaJPARep extends JpaRepository<Rematricula, Integer> {
    
    List<Rematricula> findByCpfAluno(String cpfAluno);
}
