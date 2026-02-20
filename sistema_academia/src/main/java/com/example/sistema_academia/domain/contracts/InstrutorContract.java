package com.example.sistema_academia.domain.contracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.sistema_academia.domain.entities.Instrutor;
import com.example.sistema_academia.domain.entities.Treino;

public interface InstrutorContract {
    
        boolean cadastrarInstrutor(Instrutor instrutor);
        boolean validarCPFInstrutor(String cpf);
        boolean validarIdInstrutor(int id);
        Page<Instrutor> listarInstrutores(Pageable pageable);
        boolean criarTreino(Treino treino);
        boolean validarNomeAluno(String nomeAluno);
        boolean validarNomeInstrutor(String nomeinstrutor);
}
