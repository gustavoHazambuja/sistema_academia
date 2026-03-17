package com.example.sistema_academia.application.dtos;

import java.time.LocalDate;

import com.example.sistema_academia.domain.entities.Rematricula;
import com.example.sistema_academia.domain.enums.EnumPlano;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RematriculaResumoDTO {
    
    private Long id;
    private EnumPlano planoAcademia;
    private LocalDate dataRematricula = LocalDate.now();


    public static RematriculaResumoDTO fromModel(Rematricula rematricula){
        return new RematriculaResumoDTO(
            rematricula.getId(),
            rematricula.getPlanoAcademia(),
            rematricula.getDataRematricula()
        );
    }
}
