package com.example.sistema_academia.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistema_academia.domain.contracts.TreinoContract;
import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.domain.entities.Instrutor;
import com.example.sistema_academia.domain.entities.Treino;

@Service
public class TreinoService {
    
    @Autowired
    private TreinoContract treinoContract;

    @Autowired
    private InstrutorService instrutorService;

    @Autowired
    private AlunoService alunoService;


    public boolean criarTreino(Treino treino){
        
        List<Instrutor> instrutores = instrutorService.buscarInstrutorPorNome(treino.getNomeInstrutor());
        List<Aluno> alunos = alunoService.buscarAlunoPorNome(treino.getNomeAluno());

        if(alunos == null || instrutores == null){
            return false;
        }

        boolean cpfJaExiste = alunoService.validarCPFAluno(treino.getCpfAluno());

        if(!cpfJaExiste){
            return false;
        }

        return treinoContract.criarTreino(treino);
    }

    public List<Treino> listarTreinos(String cpfAluno){
        return treinoContract.listarTreinos(cpfAluno);
    }

}
