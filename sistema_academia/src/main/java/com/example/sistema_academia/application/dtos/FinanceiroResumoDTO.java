package com.example.sistema_academia.application.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.sistema_academia.domain.entities.Financeiro;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FinanceiroResumoDTO {
    
    private Long id;
    private BigDecimal valor;
    private LocalDateTime dataPagamento = LocalDateTime.now();


    public static FinanceiroResumoDTO fromModel(Financeiro financeiro){
        return new FinanceiroResumoDTO(
            financeiro.getId(),
            financeiro.getValor(),
            financeiro.getDataPagamento()
        );
    }
}
