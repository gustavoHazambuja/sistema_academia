package com.example.sistema_academia.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistema_academia.domain.contracts.TreinoContract;
import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.domain.entities.Instrutor;
import com.example.sistema_academia.domain.entities.Treino;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TreinoService {
    
    @Autowired
    private TreinoContract treinoContract;

    @Autowired
    private InstrutorService instrutorService;

    @Autowired
    private AlunoService alunoService;


    public boolean criarTreino(Treino treino){
        
        Optional<Instrutor> instrutores = instrutorService.buscarInstrutorPorCpf(treino.getCpfInstrutor());
        Optional<Aluno> alunos = alunoService.buscarAlunoPorCpf(treino.getCpfAluno());

        if(alunos.isEmpty() || instrutores.isEmpty()){
            return false;
        }

        return treinoContract.criarTreino(treino);
    }

    public List<Treino> listarTreinos(String cpfAluno){
        return treinoContract.listarTreinos(cpfAluno);
    }

}
