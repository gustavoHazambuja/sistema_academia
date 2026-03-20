package com.example.sistema_academia.domain.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistema_academia.domain.contracts.FinanceiroContract;
import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.domain.entities.Financeiro;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FinanceiroService {
 
    
    @Autowired
    private FinanceiroContract financeiroContract;

    @Autowired
    private AlunoService alunoService;


    public List<Financeiro> buscarHistoricoPagamentos(String cpfAluno){
        return financeiroContract.buscarHistoricoPagamentos(cpfAluno);
    }
    

    public boolean fazerPagamento(Financeiro financeiro){

        if(financeiro == null){
            return false;
        }

        Optional<Aluno> aluno = alunoService.buscarAlunoPorCpf(financeiro.getCpfAluno());

        if(aluno.isEmpty()){
            return false;
        }

        if(!aluno.get().getPlanoAcademia().getValor().equals(financeiro.getValor())){
            return false;
        }

        return financeiroContract.fazerPagamento(financeiro);
    }


    public BigDecimal calcularFaturamentoMensal(int mes, int ano){

        BigDecimal valor = BigDecimal.ZERO;
        
        if((mes < 01 || mes > 12) || (ano < 1500 || ano > 9999)){
            return BigDecimal.ZERO;
        }
        
        YearMonth yearMonth = YearMonth.of(ano, mes);
        LocalDateTime inicio = yearMonth.atDay(1).atStartOfDay();
        LocalDateTime fim = yearMonth.atEndOfMonth().atTime(23, 59, 59);
        
        List<Financeiro> pagamentos = financeiroContract.buscarPagamentosEntreDatas(inicio, fim);

        for(Financeiro pagamento: pagamentos){
            if(pagamento.getValor() != null){
                valor = valor.add(pagamento.getValor());
            }
        }

        return valor;
    }
}
