package br.com.apionlineclassgestao.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name="colaborador", schema = "public")
@Data
public class Colaborador implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;
	
	@NonNull
	@OneToOne
	@JoinColumn(name = "id_dados_pessoais", referencedColumnName = "id")
	private DadosPessoais dadosPessoais;
	
	@NonNull
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "data_cadastro")
	private LocalDateTime dataCadastro;
	
	@NonNull
	@Column
	private String senha;
	
	
	
}
