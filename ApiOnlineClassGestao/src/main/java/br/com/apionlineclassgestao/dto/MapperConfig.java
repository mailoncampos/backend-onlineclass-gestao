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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
							
	
		
		return new ModelMapper();
	}
}
