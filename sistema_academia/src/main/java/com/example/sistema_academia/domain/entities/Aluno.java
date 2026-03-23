package com.example.sistema_academia.domain.entities;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.sistema_academia.domain.enums.EnumPlano;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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

    

    public Aluno(String cpf,String nome,String email, String telefone, LocalDate dataNascimento, EnumPlano planoAcademia) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.planoAcademia = planoAcademia;
    }

    

    public Aluno(Long id, String nome, String email,LocalDate dataMatricula,EnumPlano planoAcademia) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataMatricula = LocalDate.now();
        this.planoAcademia = planoAcademia;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno_seq")
    @SequenceGenerator(name = "aluno_seq", sequenceName = "aluno_id_seq", allocationSize = 1)
    private Long id;
    
    @Column(unique = true)
    private String cpf;

    private String nome;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String telefone;
    
    private LocalDate dataNascimento;
    private LocalDate dataMatricula = LocalDate.now();
    private EnumPlano planoAcademia;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
    private List<Treino> treinos = new ArrayList<>();

}
