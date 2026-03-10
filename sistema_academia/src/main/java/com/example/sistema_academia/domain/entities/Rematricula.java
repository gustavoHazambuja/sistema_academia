package com.example.sistema_academia.domain.entities;

import java.time.LocalDate;

import com.example.sistema_academia.domain.enums.EnumPlano;

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
@Table(name = "tb_rematricula")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rematricula {

    

    public Rematricula(String cpfAluno, Integer aluno_id,EnumPlano planoAcademia,LocalDate dataRematricula) {
        this.cpfAluno = cpfAluno;
        this.aluno_id = aluno_id;
        this.planoAcademia = planoAcademia;
        this.dataRematricula = LocalDate.now();
    }

    public Rematricula(EnumPlano planoAcademia, LocalDate dataRematricula){
        this.planoAcademia = planoAcademia;
        this.dataRematricula = dataRematricula;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cpfAluno;
    private Integer aluno_id;

    private EnumPlano planoAcademia;

    private LocalDate dataRematricula = LocalDate.now();
}
