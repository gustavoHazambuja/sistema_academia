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


    
    
    public Treino(String cpfAluno, Integer aluno_id,Integer instrutor_id,String objetivo, LocalDate dataCriacao) {
        this.cpfAluno = cpfAluno;
        this.aluno_id = aluno_id;
        this.instrutor_id = instrutor_id;
        this.objetivo = objetivo;
        this.dataCriacao = LocalDate.now();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cpfAluno;
    private Integer aluno_id;
    private Integer instrutor_id;
    private String objetivo;
    private LocalDate dataCriacao = LocalDate.now();
}
