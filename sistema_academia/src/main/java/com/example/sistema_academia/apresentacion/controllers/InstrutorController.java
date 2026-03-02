package com.example.sistema_academia.apresentacion.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistema_academia.application.dtos.InstrutorDTO;
import com.example.sistema_academia.application.dtos.InstrutorResumoDTO;
import com.example.sistema_academia.application.dtos.TreinoDTO;
import com.example.sistema_academia.application.usecases.InstrutorUC;

@RestController
@RequestMapping(value = "/instrutores")
public class InstrutorController {
    
    @Autowired
    private InstrutorUC instrutorUC;


    @GetMapping(value = "/validarCPF/{cpf}")
    public boolean validarCPFInstrutor(@PathVariable String cpf){
        return instrutorUC.validarCPFInstrutor(cpf);
    }

    @GetMapping(value = "/validarId/{id}")
    public boolean validarIdInstrutor(@PathVariable int id){
        return instrutorUC.validarIdInstrutor(id);
    }

    @PostMapping(value = "/cadastroInstrutor")
    public ResponseEntity<?> cadastrarInstrutor(@RequestBody InstrutorDTO dto){
        boolean resposta = instrutorUC.cadastrarInstrutor(dto);

        if(resposta){
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "Instrutor cadastrado com sucesso." ));
        }
        else{
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "Falha no cadastro: CPF já cadastrado." ));
        }
    }

    @GetMapping(value = "listarInstrutores")
    public ResponseEntity<Page<InstrutorResumoDTO>> listarInstrutores(Pageable pageable){

        Page<InstrutorResumoDTO> result = instrutorUC.listarInstrutores(pageable);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping(value = "/validarNomeAluno/{nome}")
    public boolean validarNomeALuno(@PathVariable String nome){
        return instrutorUC.validarNomeAluno(nome);
    }

    @GetMapping(value = "/validarNomeInstrutor/{nome}")
    public boolean validarNomeInstrutor(@PathVariable String nome){
        return instrutorUC.validarNomeInstrutor(nome);
    }


    @GetMapping(value = "/criarTreino")
    public ResponseEntity<?> criarTreino(@RequestBody TreinoDTO dto){
        boolean resposta = instrutorUC.criarTreino(dto);

        if(resposta){
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "Treino criado com sucesso." ));
        }
        else{
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "Nome do aluno ou do instrutor inválido." ));
        }

    }


}
