package com.example.sistema_academia.domain.entities;


import java.time.LocalDate;

import com.example.sistema_academia.domain.enums.EnumPlano;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_aluno")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    

    public Aluno(String cpf,String nome,String telefone, LocalDate dataNascimento, EnumPlano planoAcademia) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.planoAcademia = planoAcademia;
    }

    

    public Aluno(Integer id, String nome, String email,LocalDate dataMatricula,EnumPlano planoAcademia) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataMatricula = LocalDate.now();
        this.planoAcademia = planoAcademia;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private LocalDate dataMatricula = LocalDate.now();
    private EnumPlano planoAcademia;

    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

}
