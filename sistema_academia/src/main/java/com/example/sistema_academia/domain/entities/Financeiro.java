package com.example.sistema_academia.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_financeiro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Financeiro {

    public Financeiro(Long id, BigDecimal valor, LocalDateTime dataPagamento){
        this.id = id;
        this.valor = valor;
        this.dataPagamento = LocalDateTime.now();
    }

    public Financeiro(BigDecimal valor, String cpfAluno){
        this.valor = valor;
        this.cpfAluno = cpfAluno;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "financeiro_seq")
    @SequenceGenerator(name = "financeiro_seq", sequenceName = "financeiro_id_seq", allocationSize = 1)
    private Long id;

    private BigDecimal valor;
    private String cpfAluno;
    private LocalDateTime dataPagamento = LocalDateTime.now();
}
