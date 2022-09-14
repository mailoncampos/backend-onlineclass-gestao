package br.com.apionlineclassgestao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apionlineclassgestao.model.DadosPessoais;
import br.com.apionlineclassgestao.repository.DadosPessoaisRepository;

@Service
public class DadosPessoaisService {

	@Autowired
	private DadosPessoaisRepository dadosPessoaisRepository;
	
	public DadosPessoais salvarDadosPessoais(DadosPessoais dadosPessoais) {
		return dadosPessoaisRepository.save(dadosPessoais);
	}
	
	public DadosPessoais buscarDadosPessoaisPorId(Long id) {
		return dadosPessoaisRepository.findById(id).get();
	}
	
	public DadosPessoais atualizarDadosPessoais(DadosPessoais dadosPessoais) {
		return dadosPessoaisRepository.save(dadosPessoais);
	}
	
	public void deletarDadosPessoaisPorId(Long id) {
		dadosPessoaisRepository.deleteById(id);
	}
}
