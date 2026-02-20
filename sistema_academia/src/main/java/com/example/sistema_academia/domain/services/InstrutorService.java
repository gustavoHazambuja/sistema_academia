package com.example.sistema_academia.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.sistema_academia.domain.contracts.InstrutorContract;
import com.example.sistema_academia.domain.entities.Instrutor;
import com.example.sistema_academia.domain.entities.Treino;

@Service
public class InstrutorService {
    
    @Autowired
    private InstrutorContract instrutorContract;

    public boolean validarCPFInstrutor(String cpf){
        return instrutorContract.validarCPFInstrutor(cpf);
    }

    public boolean cadastrarInstrutor(Instrutor instrutor){
        if(validarCPFInstrutor(instrutor.getCpf())){
            return true;
        }
        return false;
    }

    public boolean validarIdInstrutor(int id){
        return instrutorContract.validarIdInstrutor(id);
    }

    public Page<Instrutor> listarinstrutores(Pageable pageable){
        return instrutorContract.listarInstrutores(pageable);
    }

    public boolean validarNomeAluno(String nomeAluno){
        return instrutorContract.validarNomeAluno(nomeAluno);
    }

    public boolean validarNomeInstrutor(String nomeinstrutor){
        return instrutorContract.validarNomeInstrutor(nomeinstrutor);
    }

    public boolean criarTreino(Treino treino){
        if(validarNomeAluno(treino.getAluno().getNome()) && validarNomeInstrutor(treino.getInstrutor().getNome())){
            return true;
        }
        return false;
    }

   
}
