package com.example.sistema_academia.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

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
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "financeiro_seq")
    @SequenceGenerator(name = "financeiro_seq", sequenceName = "financeiro_id_seq", allocationSize = 1)
    private Long id;

    private BigDecimal valor;
    private String cpfAluno;
    private LocalDate dataPagamento = LocalDate.now();
}
