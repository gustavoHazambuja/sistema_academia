package com.example.sistema_academia.domain.contracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.sistema_academia.domain.entities.Instrutor;

public interface InstrutorContract {
    
        boolean cadastrarInstrutor(Instrutor instrutor);
        boolean validarCPFInstrutor(String cpf);
        boolean validarIdInstrutor(Long id);
        void deletarInstrutorPorId(Long id);
        Page<Instrutor> listarInstrutores(Pageable pageable);
        boolean validarNomeAluno(String nomeAluno);
        boolean validarNomeInstrutor(String nomeinstrutor);
        List<Instrutor> buscarInstrutorPorNome(String nome);
        Optional<Instrutor> buscarInstrutorPorId(Long id);
        Optional<Instrutor> buscarInstrutorPorCpf(String cpf);
}
