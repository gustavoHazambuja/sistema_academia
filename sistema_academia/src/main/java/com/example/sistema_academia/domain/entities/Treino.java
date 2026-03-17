package com.example.sistema_academia.domain.entities;

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
@Table(name = "tb_treino")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Treino {


    
    
    public Treino(String cpfAluno,String cpfInstrutor,String objetivo, LocalDate dataCriacao) {
        this.cpfAluno = cpfAluno;
        this.cpfInstrutor = cpfInstrutor;
        this.objetivo = objetivo;
        this.dataCriacao = LocalDate.now();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "treino_seq")
    @SequenceGenerator(name = "treino_seq", sequenceName = "treino_id_seq", allocationSize = 1)
    private Long id;

    private String cpfAluno;
    private String cpfInstrutor;
    private String objetivo;
    private LocalDate dataCriacao = LocalDate.now();
}
