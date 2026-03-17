package com.example.sistema_academia.domain.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.sistema_academia.domain.enums.EnumTurno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_instrutor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Instrutor {


    
    
    public Instrutor(String cpf,String nome,String email,String telefone,LocalDate dataNascimento,String formacao,EnumTurno turnoAula) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.formacao = formacao;
        this.turnoAula = turnoAula;
    }

    

    public Instrutor(Long id, String nome, String email,String telefone, String formacao,EnumTurno turnoAula) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.formacao = formacao;
        this.turnoAula = turnoAula;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instrutor_seq")
    @SequenceGenerator(name = "instrutor_seq", sequenceName = "instrutor_id_seq", allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String cpf;

    private String nome;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String telefone;
    
    private LocalDate dataNascimento;

    private String formacao;

    @OneToMany(mappedBy = "instrutor")
    private List<Aluno> alunos = new ArrayList<>();

    private EnumTurno turnoAula;
}
