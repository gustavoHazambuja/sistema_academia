package com.example.sistema_academia.application.dtos;

import com.example.sistema_academia.domain.entities.Instrutor;
import com.example.sistema_academia.domain.enums.EnumTurno;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstrutorResumoDTO {
    
    private int id;
    private String nome;
    private String email;
    private String formacao;
    private EnumTurno turnoAula;



    public static InstrutorResumoDTO fromModel(Instrutor instrutor){
        return new InstrutorResumoDTO(
            instrutor.getId(),
            instrutor.getCpf(),
            instrutor.getEmail(),
            instrutor.getFormação(),
            instrutor.getTurnoAula());
    }
}
