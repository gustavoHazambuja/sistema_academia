package com.example.sistema_academia.application.usecases;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.example.sistema_academia.application.dtos.InstrutorDTO;
import com.example.sistema_academia.application.dtos.InstrutorDetalhadoDTO;
import com.example.sistema_academia.application.dtos.InstrutorResumoDTO;
import com.example.sistema_academia.application.dtos.TreinoDTO;
import com.example.sistema_academia.domain.entities.Instrutor;
import com.example.sistema_academia.domain.entities.Treino;
import com.example.sistema_academia.domain.services.InstrutorService;

@Component
public class InstrutorUC {
    
    @Autowired
    private InstrutorService instrutorService;



    public boolean validarCPFInstrutor(String cpf){
        return instrutorService.validarCPFInstrutor(cpf);
    }

    public boolean cadastrarInstrutor(InstrutorDTO dto){
        Instrutor instrutor = toModel(dto);
        return instrutorService.cadastrarInstrutor(instrutor);
    }

    public boolean validarIdInstrutor(int id){
        return instrutorService.validarIdInstrutor(id);
    }

    public Page<InstrutorResumoDTO> listarInstrutores(Pageable pageable){
        return instrutorService.listarinstrutores(pageable)
            .map(InstrutorResumoDTO::fromModel);
    }

    public boolean validarNomeAluno(String nome){
        return instrutorService.validarNomeAluno(nome);
    }

    public boolean validarNomeInstrutor(String nome){
        return instrutorService.validarNomeInstrutor(nome);
    }

    public boolean criarTreino(TreinoDTO dto){
        Treino treino = toModel(dto);
        return instrutorService.criarTreino(treino);
    }

    public InstrutorDetalhadoDTO buscarInstrutorPorNome(String nome){
        
        Instrutor instrutor = instrutorService.buscarInstrutorPorNome(nome).get();
        return InstrutorDetalhadoDTO.fromModel(instrutor);
    }




    private Instrutor toModel(InstrutorDTO dto){
        return new Instrutor(
            dto.getCpf(),
            dto.getNome(),
            dto.getEmail(),
            dto.getTelefone(),
            dto.getDataNascimento(),
            dto.getFormacao(),
            dto.getTurnoAula());
    }

    private Treino toModel(TreinoDTO dto){
        return new Treino(
            dto.getNomeALuno(),
            dto.getNomeInstrutor(),
            dto.getObjetivo(),
            dto.getDatacriacao());
    }
}
