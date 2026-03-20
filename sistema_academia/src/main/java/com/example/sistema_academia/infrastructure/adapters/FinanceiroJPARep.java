package com.example.sistema_academia.infrastructure.adapters;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema_academia.domain.entities.Financeiro;

public interface FinanceiroJPARep extends JpaRepository<Financeiro, Long>{

    List<Financeiro> findByCpfAluno(String cpfAluno);
    
    List<Financeiro> findByDataPagamentoBetween(LocalDateTime dataInicio, LocalDateTime dataFim);
}
