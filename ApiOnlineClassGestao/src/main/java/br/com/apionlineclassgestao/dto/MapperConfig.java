package br.com.apionlineclassgestao.dto;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.apionlineclassgestao.model.Colaborador;
import br.com.apionlineclassgestao.model.DadosPessoais;

@Configuration
public class MapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		
		ModelMapper modelMapper = new ModelMapper();

		modelMapper.createTypeMap(ColaboradorDTO.class, DadosPessoais.class)
			.<String>addMapping(src -> src.getDataNascimento(), 
			(dest, value) -> dest.setDataNascimento(value));
			
			
		modelMapper.createTypeMap(Colaborador.class, ColaboradorDTO.class)
				.<String>addMapping(src -> src.getDadosPessoais().getNome(), (dest, value) -> dest.setNome(value))
				.<String>addMapping(src -> src.getDadosPessoais().getCpf(), (dest, value) -> dest.setCpf(value))
				.<String>addMapping(src -> src.getDadosPessoais().getDataNascimento(), (dest, value) -> dest.setDataNascimento(value));
	
		
		return modelMapper;
	}
}
