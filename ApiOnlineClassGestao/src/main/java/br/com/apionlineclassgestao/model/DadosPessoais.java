package br.com.apionlineclassgestao.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import lombok.Data;

@Entity
@Table(name="dados_pessoais", schema = "public")
@Data
public class DadosPessoais implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @Column
    private String nome;
    
    @Column
    private String cpf;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Column(name="data_nascimento")
    private LocalDate dataNascimento;
    
	public void setDataNascimento(String dataNascimento) throws Exception {
		try {
			if(LocalDate.now().isBefore(LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd-MM-yyyy")))) {
				throw new Exception("Data de Nascimento não pode ser posterior a data atual"); 
			}
			this.dataNascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
