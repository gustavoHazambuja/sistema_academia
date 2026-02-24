package com.example.sistema_academia.domain.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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


    
    
    public Treino(Aluno aluno,Instrutor instrutor,String objetivo, LocalDate dataCriacao) {
        this.aluno = aluno;
        this.instrutor = instrutor;
        this.objetivo = objetivo;
        this.dataCriacao = dataCriacao;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private Aluno aluno;

    @NotNull
    private Instrutor instrutor;

    @NotBlank(message = "O objetivo é obtigatório")
    private String objetivo;

    @NotNull
    private LocalDate dataCriacao;
}
