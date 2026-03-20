package com.example.sistema_academia.domain.contracts;

import java.util.List;

import com.example.sistema_academia.domain.entities.Treino;

public interface TreinoContract {
    
    boolean criarTreino(Treino treino);
    List<Treino> buscarHistoricoTreinos(String cpfAluno);
}
