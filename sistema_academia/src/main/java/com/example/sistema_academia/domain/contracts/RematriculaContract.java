package com.example.sistema_academia.domain.contracts;

import java.util.List;

import com.example.sistema_academia.domain.entities.Rematricula;

public interface RematriculaContract {
    
    boolean fazerRematricula(Rematricula rematricula);
    List<Rematricula> buscarHistoricoRematriculas(String cpfAluno);
}
