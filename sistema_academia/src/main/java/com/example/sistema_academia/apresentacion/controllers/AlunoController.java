package com.example.sistema_academia.apresentacion.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistema_academia.application.dtos.AlunoDTO;
import com.example.sistema_academia.application.dtos.AlunoDetalhadoDTO;
import com.example.sistema_academia.application.dtos.AlunoResumoDTO;
import com.example.sistema_academia.application.usecases.AlunoUC;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {
    

    @Autowired
    private AlunoUC alunoUC;

    @GetMapping(value = "/validarCPFAluno/{cpf}")
    public boolean validarCPFAluno(@PathVariable String cpf){
        return alunoUC.validarCPFAluno(cpf);
    }

    @PostMapping(value = "/cadastroAluno")
    public ResponseEntity<?> cadastrarAluno(@Valid @RequestBody AlunoDTO dto){
        boolean resposta = alunoUC.cadastrarAluno(dto);

        if(resposta){
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "Aluno cadastrado com sucesso." ));
        }
        else{
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "Falha no cadastro: CPF já cadastrado." ));
        }
    }

    @GetMapping(value = "/validarIdAluno/{id}")
    public boolean validarIdAluno(@PathVariable int id){
        return alunoUC.validarIdAluno(id);
    }

    @DeleteMapping(value = "/deletarAluno/{id}")
    public ResponseEntity<Void> deletarALunoPorId(@PathVariable int id){
         alunoUC.deletarAlunoPorId(id);
         return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/listarAlunos")
    public ResponseEntity<Page<AlunoResumoDTO>> listarAlunos(Pageable pageable){

        Page<AlunoResumoDTO> result = alunoUC.listarAlunos(pageable);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping(value = "/buscarPorCpf/{cpf}")
    public ResponseEntity<AlunoDetalhadoDTO> buscarALunoPorCpf(@PathVariable String cpf){

        AlunoDetalhadoDTO result = alunoUC.buscarAlunoPorCpf(cpf);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }


    @GetMapping(value = "/buscarPorNome/aluno/{nome}")
    public ResponseEntity<List<AlunoDetalhadoDTO>> buscarAlunoPorNome(@PathVariable String nome){

        List<AlunoDetalhadoDTO> result = alunoUC.buscarAlunoPorNome(nome);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
