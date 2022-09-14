package br.com.apionlineclassgestao.model;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="dados_pessoais", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DadosPessoais implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String nome;
    
    @Column
    private String cpf;
    
    @Past(message = "Data de aniversário não pode ser posterior a data atual!")
    @Column(name="data_nascimento")
    private Date dataNascimento;
    
	public void setDataNascimento(String dataNascimento) {	
		this.dataNascimento =Date.valueOf(LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}
	
	public String getDataNascimento() {
		return this.dataNascimento.toString();
	}
	
}
