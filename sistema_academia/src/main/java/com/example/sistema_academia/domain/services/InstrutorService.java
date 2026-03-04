package com.example.sistema_academia.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sistema_academia.domain.contracts.InstrutorContract;
import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.domain.entities.Instrutor;
import com.example.sistema_academia.domain.entities.Treino;

@Service
@Transactional
public class InstrutorService {
    
    @Autowired
    private InstrutorContract instrutorContract;

    @Autowired
    private AlunoService alunoService;

    public boolean validarCPFInstrutor(String cpf){
        return instrutorContract.validarCPFInstrutor(cpf);
    }

    public boolean cadastrarInstrutor(Instrutor instrutor){
        
        if(instrutor == null){
            return false;
        }

        boolean cpfJaExiste = validarCPFInstrutor(instrutor.getCpf());

        if(cpfJaExiste){
            return false;
        }

        return instrutorContract.cadastrarInstrutor(instrutor);
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

    public Optional<Instrutor> buscarInstrutorPorNome(String nome){
        return instrutorContract.buscarInstrutorPorNome(nome);
    }

    public boolean criarTreino(Treino treino){
       
        Aluno aluno = alunoService.buscarAlunoPorNome(treino.getNomeAluno()).get();
        Instrutor instrutor = buscarInstrutorPorNome(treino.getNomeInstrutor()).get();


        if(aluno == null || instrutor == null){
            return false;
        }

        return instrutorContract.criarTreino(treino);
    }

   
}
