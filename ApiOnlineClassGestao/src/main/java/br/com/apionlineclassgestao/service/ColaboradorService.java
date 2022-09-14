package br.com.apionlineclassgestao.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apionlineclassgestao.model.Colaborador;
import br.com.apionlineclassgestao.model.DadosPessoais;
import br.com.apionlineclassgestao.repository.ColaboradorRepository;

@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private DadosPessoaisService dadosPessoaisService;

	public Colaborador salvarColaborador(Colaborador colaborador, DadosPessoais dadosPessoais) {
		
		String senhaPadrao = "colaborador";
		
		
		DadosPessoais dadosPessoaisSalvo = dadosPessoaisService.salvarDadosPessoais(dadosPessoais);
		if(dadosPessoaisSalvo == null) {
			return null; //Criar mensagem de erro
		}
		
		colaborador.setDataCadastro(LocalDateTime.now());
		colaborador.setSenha(senhaPadrao);
		colaborador.setDadosPessoais(dadosPessoaisSalvo);
		return colaboradorRepository.save(colaborador);
	}
}
