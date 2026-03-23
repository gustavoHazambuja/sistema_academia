package com.example.sistema_academia.application.dtos;

import java.time.LocalDate;
import java.util.List;

import com.example.sistema_academia.domain.entities.Instrutor;
import com.example.sistema_academia.domain.enums.EnumTurno;

public record InstrutorDetalhadoDTO(Long id, String cpf, String nome,
                                    String email, String telefone, LocalDate dataNascimento,
                                    String formacao, List<TreinoResumoDTO> treinos, EnumTurno turnoAula
) {



    public static InstrutorDetalhadoDTO fromModel(Instrutor instrutor){

        List<TreinoResumoDTO> treinosDTO = instrutor.getTreinos()
            .stream()
            .map(TreinoResumoDTO::fromModel)
            .toList();


        return new InstrutorDetalhadoDTO(
            instrutor.getId(),
            instrutor.getCpf(),
            instrutor.getNome(),
            instrutor.getEmail(),
            instrutor.getTelefone(),
            instrutor.getDataNascimento(),
            instrutor.getFormacao(),
            treinosDTO,
            instrutor.getTurnoAula());
    }
    
}
