package com.example.sistema_academia.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sistema_academia.domain.contracts.InstrutorContract;
import com.example.sistema_academia.domain.entities.Instrutor;

@Service
@Transactional
public class InstrutorService {
    
    @Autowired
    private InstrutorContract instrutorContract;

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

    public boolean validarIdInstrutor(Long id){
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

    public List<Instrutor> buscarInstrutorPorNome(String nome){
        return instrutorContract.buscarInstrutorPorNome(nome);
    }

    public void deletarInstrutorPorId(Long id){
         instrutorContract.deletarInstrutorPorId(id);
    }

    public Optional<Instrutor> buscarInstrutorPorId(Long id){
        return instrutorContract.buscarInstrutorPorId(id);
    }

    public Optional<Instrutor> buscarInstrutorPorCpf(String cpf){
        return instrutorContract.buscarInstrutorPorCpf(cpf);
    }

   
}
