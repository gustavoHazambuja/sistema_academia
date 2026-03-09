package com.example.sistema_academia.domain.contracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.sistema_academia.domain.entities.Instrutor;

public interface InstrutorContract {
    
        boolean cadastrarInstrutor(Instrutor instrutor);
        boolean validarCPFInstrutor(String cpf);
        boolean validarIdInstrutor(int id);
        void deletarInstrutorPorId(int id);
        Page<Instrutor> listarInstrutores(Pageable pageable);
        boolean validarNomeAluno(String nomeAluno);
        boolean validarNomeInstrutor(String nomeinstrutor);
        List<Instrutor> buscarInstrutorPorNome(String nome);
}
