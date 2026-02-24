package com.example.sistema_academia.domain.entities;

import java.time.LocalDate;

import com.example.sistema_academia.domain.enums.EnumPlano;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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

    

    public Rematricula(Aluno aluno,EnumPlano planoAcademia,LocalDate dataRematricula) {
        this.aluno = aluno;
        this.planoAcademia = planoAcademia;
        this.dataRematricula = dataRematricula;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private Aluno aluno;

    @NotNull
    private EnumPlano planoAcademia;

    @NotNull
    private LocalDate dataRematricula;
}
