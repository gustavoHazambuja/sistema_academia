package com.example.sistema_academia.domain.contracts;

import java.time.LocalDate;
import java.util.List;

import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.domain.enums.EnumPlano;


public interface AlunoContract {
    
    String cadastrarAluno(String nome, String cpf, String email, String telefone, LocalDate dataNascimento, LocalDate dataMatricula);
    boolean validarCPFAluno(String cpf);
    boolean validarIdAluno(int id);
    String fazerRematricula(String cpf, EnumPlano planoAcademia, LocalDate dataRematricula);
    List<Aluno> listarAlunos();
    boolean deletarAluno(int id);
}
