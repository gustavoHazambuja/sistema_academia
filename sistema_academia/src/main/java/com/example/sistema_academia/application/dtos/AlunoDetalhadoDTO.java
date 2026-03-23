package com.example.sistema_academia.application.dtos;

import java.time.LocalDate;
import java.util.List;

import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.domain.enums.EnumPlano;

public record AlunoDetalhadoDTO(Long id, String cpf, String nome, String email, 
                                String telefone, LocalDate dataNascimento, LocalDate dataMatricula, 
                                EnumPlano planoAcademia, List<TreinoResumoDTO> treinos) {
    


    public static AlunoDetalhadoDTO fromModel(Aluno aluno){

        List<TreinoResumoDTO> treinosDTO = aluno.getTreinos()
            .stream()
            .map(TreinoResumoDTO::fromModel)
            .toList();

        return new AlunoDetalhadoDTO(
        aluno.getId(),
        aluno.getCpf(),
        aluno.getNome(),
        aluno.getEmail(),
        aluno.getTelefone(),
        aluno.getDataNascimento(),
        aluno.getDataMatricula(),
        aluno.getPlanoAcademia(),
        treinosDTO);
    }
}
