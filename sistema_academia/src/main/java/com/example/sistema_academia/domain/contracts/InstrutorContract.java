package com.example.sistema_academia.domain.contracts;

import java.time.LocalDate;
import java.util.List;

import com.example.sistema_academia.domain.entities.Instrutor;

public interface InstrutorContract {
    
        String cadastrarInstrutor(String nome, String cpf, String email, String telefone, LocalDate dataNascimento, String formacao);
        boolean validarCPFInstruotor(String cpf);
        boolean validarIdInstrutor(int id);
        List<Instrutor> listarInstrutores();
        String criarTreino(String nomeAluno, String nomeInstrutor, String objetivo, LocalDate dataCriacao);
}
