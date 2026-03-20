package com.example.sistema_academia.domain.contracts;

import java.time.LocalDateTime;
import java.util.List;

import com.example.sistema_academia.domain.entities.Financeiro;

public interface FinanceiroContract {

         boolean fazerPagamento(Financeiro financeiro);
         List<Financeiro> buscarPagamentosEntreDatas(LocalDateTime inicio, LocalDateTime fim);
         List<Financeiro> buscarHistoricoPagamentos(String cpfAluno);   
    
} 
  
