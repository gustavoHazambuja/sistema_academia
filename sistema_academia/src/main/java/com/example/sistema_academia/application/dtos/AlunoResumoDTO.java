package com.example.sistema_academia.application.dtos;

import java.time.LocalDate;

import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.domain.enums.EnumPlano;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoResumoDTO {
    
    private Long id;
    private String nome;
    private String email;
    private LocalDate dataMatricula = LocalDate.now();
    private EnumPlano planoAcademia;



    public static AlunoResumoDTO fromModel(Aluno aluno){
        return new AlunoResumoDTO(
            aluno.getId(),
            aluno.getNome(),
            aluno.getEmail(),
            aluno.getDataMatricula(),
            aluno.getPlanoAcademia());
    }
}
