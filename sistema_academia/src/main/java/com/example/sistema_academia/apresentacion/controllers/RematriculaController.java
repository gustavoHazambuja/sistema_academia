package com.example.sistema_academia.apresentacion.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistema_academia.application.dtos.RematriculaDTO;
import com.example.sistema_academia.application.dtos.RematriculaResumoDTO;
import com.example.sistema_academia.application.usecases.RematriculaUC;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/rematriculas")
public class RematriculaController{


    @Autowired
    private RematriculaUC rematriculaUC;


    @PostMapping(value = "/fazerRematricula")
    public ResponseEntity<?> fazerRematricula(@Valid @RequestBody RematriculaDTO dto){
        boolean resposta = rematriculaUC.fazerRematricula(dto);

        if(resposta){
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "Rematrícula feita com sucesso."));
        }
        else{
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "CPF Ou ID inválido."));
        }
    }

    @GetMapping(value = "buscarHistorico/{cpfAluno}")
    public ResponseEntity<List<RematriculaResumoDTO>> buscarHistorico(@PathVariable String cpfAluno){

        List<RematriculaResumoDTO> result = rematriculaUC.buscarHistorico(cpfAluno);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}