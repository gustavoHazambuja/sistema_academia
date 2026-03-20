package com.example.sistema_academia.infrastructure.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sistema_academia.domain.contracts.FinanceiroContract;
import com.example.sistema_academia.domain.entities.Financeiro;
import com.example.sistema_academia.infrastructure.adapters.FinanceiroJPARep;

@Repository
public class FinanceiroRepository implements FinanceiroContract {
    

    @Autowired
    private FinanceiroJPARep financeiroJPARep;


    @Override
    public boolean fazerPagamento(Financeiro financeiro){

        if(financeiro == null){
            return false;
        }

        return financeiroJPARep.save(financeiro) != null;
    }

    @Override
    public List<Financeiro> buscarPagamentosEntreDatas(LocalDateTime inicio, LocalDateTime fim){
        return financeiroJPARep.findByDataPagamentoBetween(inicio, fim);
     }

     @Override
     public List<Financeiro> buscarHistoricoPagamentos(String cpfAluno){
        return financeiroJPARep.findByCpfAluno(cpfAluno);
     }
    

}
