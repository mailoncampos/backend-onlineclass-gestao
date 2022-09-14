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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="colaborador", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Colaborador implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
	
	@OneToOne
	@JoinColumn(name = "id_dados_pessoais", referencedColumnName = "id")
	private DadosPessoais dadosPessoais;
	

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "data_cadastro")
	private LocalDateTime dataCadastro;
	

	@Column
	private String senha;
	
	
	
}
