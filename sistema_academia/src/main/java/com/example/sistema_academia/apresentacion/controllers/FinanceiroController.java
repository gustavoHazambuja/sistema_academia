package com.example.sistema_academia.apresentacion.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistema_academia.application.dtos.FinanceiroDTO;
import com.example.sistema_academia.application.dtos.FinanceiroResumoDTO;
import com.example.sistema_academia.application.usecases.FinanceiroUC;

@RestController
@RequestMapping(value = "/financeiro")
public class FinanceiroController {
    

    @Autowired
    private FinanceiroUC financeiroUC;


    @GetMapping(value = "/buscarHistorico/{cpfAluno}")
    public ResponseEntity<List<FinanceiroResumoDTO>> buscarHistoricoPagamentos(@PathVariable String cpfAluno){

        List<FinanceiroResumoDTO> result = financeiroUC.buscarHistoricoPagamentos(cpfAluno);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping(value = "/fazerPagamento")
    public ResponseEntity<?> fazerPagamento(@RequestBody FinanceiroDTO dto){
        boolean resposta = financeiroUC.fazerPagamento(dto);

        if(resposta){
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "Pagamento feito com sucesso."));
        }
        else{
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("resposta: ", resposta, "mensagem: ", "CPF inválido ou valor não coerente com o plano."));
        }
    }

    @GetMapping(value = "/calcularFaturamento")
    public ResponseEntity<BigDecimal> calcularFaturamentoMensal(@RequestParam("mes") int mes, @RequestParam("ano") int ano){

         BigDecimal result = financeiroUC.calcularFaturamentoMensal(mes, ano);
         return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
