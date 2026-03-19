package com.example.sistema_academia.domain.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.sistema_academia.domain.contracts.AlunoContract;
import com.example.sistema_academia.domain.contracts.FinanceiroContract;
import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.domain.entities.Financeiro;

@Service
public class FinanceiroService {
 
    
    @Autowired
    private FinanceiroContract financeiroContract;

    @Autowired
    private AlunoContract alunoContract;


    public List<Financeiro> buscarHistoricoPagamento(String cpfAluno){
        return financeiroContract.buscarHistoricoPagamento(cpfAluno);
    }

    public BigDecimal calcularFaturamentoMensal(int mes, int ano){

        BigDecimal valor = BigDecimal.ZERO;
        
        if((mes < 1 || mes > 12) || (ano < 1500 || ano > 9999)){
            return BigDecimal.ZERO;
        }
        
        List<Financeiro> pagamentos = financeiroContract.buscarPagamentosPorMesEAno(mes, ano);

        for(Financeiro pagamento: pagamentos){
            if(pagamento.getValor() != null){
                valor = valor.add(pagamento.getValor());
            }
        }

        return valor;
    }
}
