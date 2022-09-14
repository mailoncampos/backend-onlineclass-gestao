package br.com.apionlineclassgestao.resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apionlineclassgestao.dto.ColaboradorDTO;
import br.com.apionlineclassgestao.model.DadosPessoais;
import br.com.apionlineclassgestao.service.ColaboradorService;
import br.com.apionlineclassgestao.service.DadosPessoaisService;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorResource {
	
	@Autowired
	private ColaboradorService colaboradorService;

	@Autowired
	private DadosPessoaisService dadosPessoaisService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<EntityModel<ColaboradorDTO>> cadastrarColaborador(@RequestBody ColaboradorDTO colaboradorDTO){
		
		DadosPessoais dadosPessoais = modelMapper.map(colaboradorDTO, DadosPessoais.class);
//		DadosPessoais dadosPessoais = new DadosPessoais();
//		BeanUtils.copyProperties(colaboradorDTO, dadosPessoais);
		return null;
		
	}
}
