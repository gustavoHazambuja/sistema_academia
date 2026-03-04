package com.example.sistema_academia.application.dtos;

import java.time.LocalDate;

import com.example.sistema_academia.domain.enums.EnumTurno;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstrutorDTO {
    

    @NotBlank (message = "O CPF é obrigatório") @Size(min = 11, max = 11, message = "O cpf deve ter 11 caracteres")
    private String cpf;

    @NotBlank (message = "O nome é obrigatório")
    private String nome;

    @Email(message = "Email inválido")  @NotBlank(message = "O email é obrigatório")
    private String email;

    @NotBlank (message = "O telefone é obrigatório") @Size(min = 8, max = 12, message = "O telefone deve ter entre 8 e 12 caracteres")  
    private String telefone;

    @NotNull (message = "O telefone é obrigatório") @Size(min = 8, max = 12, message = "O telefone deve ter entre 8 e 12 caracteres")
    private LocalDate dataNascimento;

    @NotBlank(message = "A formação é obrigatório")
    private String formacao;

    @NotNull(message = "O turno é obrigatório")
    private EnumTurno turnoAula;
}
