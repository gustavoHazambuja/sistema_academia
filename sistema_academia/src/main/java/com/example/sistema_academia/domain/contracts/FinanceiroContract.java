package com.example.sistema_academia.domain.contracts;

import java.math.BigDecimal;
import java.util.List;

import com.example.sistema_academia.domain.entities.Financeiro;

public interface FinanceiroContract {

         boolean fazerPagamento(Financeiro financeiro);
         BigDecimal calcularFaturamentoMensal(int mes, int ano);
         List<Financeiro> buscarPagamentosPorMesEAno(int mes, int ano);
         List<Financeiro> buscarHistoricoPagamento(String cpfAluno);   
    
} 
  

