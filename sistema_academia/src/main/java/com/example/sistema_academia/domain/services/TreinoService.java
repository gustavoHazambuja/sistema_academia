package com.example.sistema_academia.domain.services;

import java.util.List;
import java.util.Optional;

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
        
        Optional<Instrutor> instrutores = instrutorService.buscarInstrutorPorId(treino.getInstrutor_id());
        Optional<Aluno> alunos = alunoService.buscarAlunoPorId(treino.getAluno_id());

        if(alunos.isEmpty() || instrutores.isEmpty()){
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
