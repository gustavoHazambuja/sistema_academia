package com.example.sistema_academia.domain.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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


    
    
    public Treino(String cpfAluno,String cpfInstrutor,String objetivoAluno, LocalDate dataCriacao) {
        this.cpfAluno = cpfAluno;
        this.cpfInstrutor = cpfInstrutor;
        this.objetivoAluno = objetivoAluno;
        this.dataCriacao = LocalDate.now();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "treino_seq")
    @SequenceGenerator(name = "treino_seq", sequenceName = "treino_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

    @Transient
    private String cpfAluno;

    @Transient
    private String cpfInstrutor;

    private String objetivoAluno;
    private LocalDate dataCriacao = LocalDate.now();
}
