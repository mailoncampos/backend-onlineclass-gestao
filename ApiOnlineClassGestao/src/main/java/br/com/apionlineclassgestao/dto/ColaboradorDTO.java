package br.com.apionlineclassgestao.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ColaboradorDTO {

    private String nome;
    
    private String cpf;
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String dataNascimento;
	
}
