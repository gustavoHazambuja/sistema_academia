package com.example.sistema_academia.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.sistema_academia.domain.contracts.InstrutorContract;
import com.example.sistema_academia.domain.entities.Instrutor;
import com.example.sistema_academia.domain.entities.Treino;
import com.example.sistema_academia.infrastructure.adapters.InstrutorJPARep;
import com.example.sistema_academia.infrastructure.adapters.TreinoJPARep;


@Repository
public class InstrutorRepository implements InstrutorContract{
    

    @Autowired
    private InstrutorJPARep instrutorJPARep;

    @Autowired
    private TreinoJPARep treinoJPARep;


    @Override
    public boolean cadastrarInstrutor(Instrutor instrutor){
        if(instrutor == null){
            return false;
        }

        return instrutorJPARep.save(instrutor) != null;
    }

    @Override
    public boolean validarCPFInstrutor(String cpf){
        return instrutorJPARep.existsByCpf(cpf);
    }

    @Override
    public boolean validarIdInstrutor(int id){
        return instrutorJPARep.existsById(id);
    }

    @Override
    public Page<Instrutor> listarInstrutores(Pageable pageable){
        return instrutorJPARep.findAll(pageable);
    }

    @Override
    public boolean criarTreino(Treino treino){
        if(treino == null){
            return false;
        }

        return treinoJPARep.save(treino) != null;
    }

    @Override
    public boolean validarNomeAluno(String nome){
        return instrutorJPARep.existsIgnoringCaseByNome(nome);
    }

    @Override
    public boolean validarNomeInstrutor(String nome){
        return instrutorJPARep.existsIgnoringCaseByNome(nome);
    }

    @Override
    public List<Instrutor> buscarInstrutorPorNome(String nome){
        return instrutorJPARep.findByNomeContainingIgnoreCase(nome);
    }
}
