package com.example.sistema_academia.domain.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistema_academia.domain.contracts.AlunoContract;
import com.example.sistema_academia.domain.contracts.FincanceiroContract;
import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.domain.entities.Financeiro;

@Service
public class FinanceiroService {
 
    
    @Autowired
    private FincanceiroContract fincanceiroContract;

    @Autowired
    private AlunoContract alunoContract;


    public List<Financeiro> buscarHistoricoPagamento(String cpfAluno){
        return fincanceiroContract.buscarHistoricoPagamento(cpfAluno);
    }

    public BigDecimal calcularFaturamentoMensak(int mes, int ano){

        BigDecimal valor = BigDecimal.ZERO;
        
        if(mes < 1 || mes > 12 && ano < 1500 || ano > 9999){
            return BigDecimal.ZERO;
        }

        return null;
    }
}
