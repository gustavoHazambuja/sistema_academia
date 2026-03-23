package com.example.sistema_academia.infrastructure.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sistema_academia.domain.contracts.TreinoContract;
import com.example.sistema_academia.domain.entities.Treino;
import com.example.sistema_academia.infrastructure.adapters.TreinoJPARep;

@Repository
public class TreinoRepository implements TreinoContract{
    

    @Autowired
    private TreinoJPARep jpaRep;


    @Override
    public boolean criarTreino(Treino treino){

        if(treino == null){
            return false;
        }

        return jpaRep.save(treino) != null;
    }

    @Override
    public List<Treino> buscarHistoricoTreinos(String cpfAluno){
        return jpaRep.findByAlunoCpf(cpfAluno);
    }
}
