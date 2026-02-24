package com.example.sistema_academia.domain.entities;


import java.time.LocalDate;

import com.example.sistema_academia.domain.enums.EnumPlano;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    

    public Aluno(String cpf,String nome,String telefone, LocalDate dataNascimento, LocalDate dataMatricula, EnumPlano planoAcademia) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataMatricula = dataMatricula;
        this.planoAcademia = planoAcademia;
    }

    

    public Aluno(int id, String nome, String email,LocalDate dataMatricula,EnumPlano planoAcademia) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataMatricula = dataMatricula;
        this.planoAcademia = planoAcademia;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank (message = "O CPF é obrigatório") @Column(unique = true)
    private String cpf;

    @NotBlank (message = "O nome é obrigatório")
    private String nome;

    @NotBlank (message = "O email é obrigatório") @Column(unique = true)
    private String email;

    @NotBlank (message = "O telefone é obrigatório") @Column(unique = true)
    private String telefone;

    @NotNull
    private LocalDate dataNascimento;

    @NotNull
    private LocalDate dataMatricula;
    
    @NotBlank (message = "O plano de adademia é obrigatório")
    private EnumPlano planoAcademia;

    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

}
