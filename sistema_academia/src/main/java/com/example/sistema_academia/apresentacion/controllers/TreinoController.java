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

import com.example.sistema_academia.application.dtos.TreinoDTO;
import com.example.sistema_academia.application.dtos.TreinoResumoDTO;
import com.example.sistema_academia.application.usecases.TreinoUC;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/treinos")
public class TreinoController {
    
    @Autowired
    private TreinoUC treinoUC;


    @PostMapping(value = "/criarTreino")
    public ResponseEntity<?> criarTreino(@Valid @RequestBody TreinoDTO dto){
        boolean resposta = treinoUC.criarTreino(dto);

        if(resposta){
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "Treino criado com sucesso"));
        }
        else{
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "CPF inválido ou id do aluno ou do instrutor inválidos."));
        }
    }

    @GetMapping("/listarTreinos/{cpfAluno}")
    public ResponseEntity<List<TreinoResumoDTO>> listarTreinos(@PathVariable String cpfAluno){
        
        List<TreinoResumoDTO> respost = treinoUC.listarTreinos(cpfAluno);
        return new ResponseEntity<>(respost,HttpStatus.OK);
    }
}
