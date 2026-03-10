package com.example.sistema_academia.application.dtos;

import java.time.LocalDate;
import java.util.List;

import com.example.sistema_academia.domain.entities.Instrutor;
import com.example.sistema_academia.domain.enums.EnumTurno;

public record InstrutorDetalhadoDTO(int id, String cpf, String nome,
                                    String email, String telefone, LocalDate dataNascimento,
                                    String formacao, List<AlunoResumoDTO> alunos, EnumTurno turnoAula
) {



    public static InstrutorDetalhadoDTO fromModel(Instrutor instrutor){

        List<AlunoResumoDTO> alunosDTO = instrutor.getAlunos()
            .stream()
            .map(AlunoResumoDTO::fromModel)
            .toList();


        return new InstrutorDetalhadoDTO(
            instrutor.getId(),
            instrutor.getCpf(),
            instrutor.getNome(),
            instrutor.getEmail(),
            instrutor.getTelefone(),
            instrutor.getDataNascimento(),
            instrutor.getFormacao(),
            alunosDTO,
            instrutor.getTurnoAula());
    }
    
}
