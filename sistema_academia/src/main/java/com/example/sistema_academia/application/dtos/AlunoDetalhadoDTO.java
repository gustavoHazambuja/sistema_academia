package com.example.sistema_academia.application.dtos;

import java.time.LocalDate;

import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.domain.entities.Instrutor;
import com.example.sistema_academia.domain.enums.EnumPlano;

public record AlunoDetalhadoDTO(int id, String cpf, String nome, String email, 
                                String telefone, LocalDate dataNascimento, LocalDate dataMatricula, 
                                EnumPlano planoAcademia, Instrutor instrutor) {
    


    public static AlunoDetalhadoDTO fromModel(Aluno aluno){
        return new AlunoDetalhadoDTO(
        aluno.getId(),
        aluno.getCpf(),
        aluno.getNome(),
        aluno.getEmail(),
        aluno.getTelefone(),
        aluno.getDataNascimento(),
        aluno.getDataMatricula(),
        aluno.getPlanoAcademia(),
        aluno.getInstrutor());
    }
}
