package com.example.sistema_academia.domain.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_treino")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Treino {


    
    
    public Treino(String nomeAluno,String nomeInstrutor,String objetivo, LocalDate dataCriacao) {
        this.nomeAluno = nomeAluno;
        this.nomeInstrutor = nomeInstrutor;
        this.objetivo = objetivo;
        this.dataCriacao = LocalDate.now();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nomeAluno;
    private String nomeInstrutor;
    private String objetivo;
    private LocalDate dataCriacao = LocalDate.now();
}
