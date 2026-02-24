package com.example.sistema_academia.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.sistema_academia.application.dtos.AlunoDTO;
import com.example.sistema_academia.application.dtos.AlunoDetalhadoDTO;
import com.example.sistema_academia.application.dtos.AlunoResumoDTO;
import com.example.sistema_academia.domain.entities.Aluno;
import com.example.sistema_academia.domain.services.AlunoService;

public class AlunoUC {
    
    @Autowired
    private AlunoService alunoService;


    public boolean validarCPFAluno(String cpf){
        return alunoService.validarCPFAluno(cpf);
    }

    public boolean validarIdAluno(int id){
        return alunoService.validarIdAluno(id);
    }

    public boolean cadastrarAluno(AlunoDTO dto){
        Aluno aluno = toModel(dto);
        return alunoService.cadastrarAluno(aluno);

    }

    public boolean deletarAluno(int id){
        return alunoService.deletarAluno(id);
    }

    public Page<AlunoResumoDTO> listarAlunos(Pageable pageable){
        return alunoService.listarAlunos(pageable)
            .map(AlunoResumoDTO::fromModel);
    }

    public AlunoDetalhadoDTO buscarAlunoPorCpf(String cpf){
        Aluno aluno = alunoService.buscarAlunoPorCpf(cpf);
        return AlunoDetalhadoDTO.fromModel(aluno);
    }

    private Aluno toModel(AlunoDTO dto){
        return new Aluno(
            dto.getCpf(),
            dto.getNome(),
            dto.getTelefone(),
            dto.getDataNascimento(),
            dto.getDataMatricula(),
            dto.getPlanoAcademia());
}
}





  
