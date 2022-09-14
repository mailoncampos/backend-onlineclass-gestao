package br.com.apionlineclassgestao.dto;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.apionlineclassgestao.model.DadosPessoais;

@Configuration
public class MapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		
		ModelMapper modelMapper = new ModelMapper();

		modelMapper.createTypeMap(ColaboradorDTO.class, DadosPessoais.class)
			.<String>addMapping(src -> src.getDataNascimento(), 
			(dest, value) -> {
				try {
					dest.setDataNascimento(value);
				} catch (Exception e) {
					e.getMessage();
					return;
				}
			});
		
//		modelMapper.createTypeMap(DadosPessoais.class, ColaboradorDTO.class)
//				.<String>addMapping(src -> src.getNome(), (dest, value) -> dest.setNome(value))
//				.<String>addMapping(src -> src.getCpf(), (dest, value) -> dest.setCpf(value));
	
		
		return new ModelMapper();
	}
}
