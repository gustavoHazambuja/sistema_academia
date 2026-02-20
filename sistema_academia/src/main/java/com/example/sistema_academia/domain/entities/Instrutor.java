package com.example.sistema_academia.domain.entities;

import java.time.LocalDate;
import java.util.List;

import com.example.sistema_academia.domain.enums.EnumTurno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @NotBlank(message = "A formação é obrigatório")
    private String formação;

    @OneToMany(mappedBy = "instrutor")
    private List<Aluno> alunos;

    @NotBlank(message = "O turno é obrigatório")
    private EnumTurno turnoAula;
}
