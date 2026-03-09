package com.example.sistema_academia.infrastructure.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sistema_academia.domain.contracts.RematriculaContract;
import com.example.sistema_academia.domain.entities.Rematricula;
import com.example.sistema_academia.infrastructure.adapters.RematriculaJPARep;


@Repository
public class RematriculaRepository implements RematriculaContract {
    

    @Autowired
    private RematriculaJPARep jpaRep;


    @Override
    public boolean fazerRematricula(Rematricula rematricula){
        if(rematricula == null){
            return false;
        }

        return jpaRep.save(rematricula) != null;
    }

    @Override
    public List<Rematricula> buscarHistorico(String cpfAluno){
        return jpaRep.findByCpfAluno(cpfAluno);
    }

}
