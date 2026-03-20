package com.example.sistema_academia.application.usecases;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sistema_academia.application.dtos.FinanceiroDTO;
import com.example.sistema_academia.application.dtos.FinanceiroResumoDTO;
import com.example.sistema_academia.domain.entities.Financeiro;
import com.example.sistema_academia.domain.services.FinanceiroService;

@Component
public class FinanceiroUC {
    
    @Autowired
    private FinanceiroService financeiroService;


    public List<FinanceiroResumoDTO> buscarHistoricoPagamentos(String cpfAluno){
        List<Financeiro> financeiro = financeiroService.buscarHistoricoPagamentos(cpfAluno);

        return financeiro.stream()
            .map(FinanceiroResumoDTO::fromModel)
            .toList();
    }

    public boolean fazerPagamento(FinanceiroDTO dto){

        Financeiro financeiro = toModel(dto);
        return financeiroService.fazerPagamento(financeiro);
    }


    public BigDecimal calcularFaturamentoMensal(int mes, int ano){
        return financeiroService.calcularFaturamentoMensal(mes, ano);
    }



    private Financeiro toModel(FinanceiroDTO dto){
        return new Financeiro(
            dto.getValor(),
            dto.getCpfAluno()
        );
    }

}
