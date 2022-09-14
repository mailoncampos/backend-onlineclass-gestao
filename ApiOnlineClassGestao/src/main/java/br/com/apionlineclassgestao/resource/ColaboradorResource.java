package br.com.apionlineclassgestao.resource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apionlineclassgestao.dto.ColaboradorDTO;
import br.com.apionlineclassgestao.model.Colaborador;
import br.com.apionlineclassgestao.model.DadosPessoais;
import br.com.apionlineclassgestao.service.ColaboradorService;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorResource {
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<EntityModel<ColaboradorDTO>> cadastrarColaborador(@RequestBody ColaboradorDTO colaboradorDTO){
		
		Colaborador colaborador = new Colaborador();
		DadosPessoais dadosPessoais = modelMapper.map(colaboradorDTO, DadosPessoais.class);
		colaborador = colaboradorService.salvarColaborador(colaborador, dadosPessoais);
		
		ColaboradorDTO colaboradorDTOSalvo = modelMapper.map(dadosPessoais, ColaboradorDTO.class);
		EntityModel<ColaboradorDTO> entityModel = EntityModel.of(colaboradorDTOSalvo);
		entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ColaboradorResource.class).cadastrarColaborador(colaboradorDTOSalvo)).withSelfRel());
		return ResponseEntity.status(HttpStatus.CREATED).body(entityModel);
		
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<EntityModel<ColaboradorDTO>> buscarColaboradorPorId(@PathVariable Long id){
		Colaborador colaborador = colaboradorService.buscarColaboradorPorId(id);
		
		if(colaborador == null ) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		ColaboradorDTO colaboradorDTOSalvo = modelMapper.map(colaborador, ColaboradorDTO.class);
		EntityModel<ColaboradorDTO> entityModel = EntityModel.of(colaboradorDTOSalvo);
		entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ColaboradorResource.class).buscarColaboradorPorId(colaborador.getId())).withSelfRel().withName("BuscarColaboradorPorId").withType("GET"));
		entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ColaboradorResource.class).cadastrarColaborador(new ColaboradorDTO())).withSelfRel().withName("CadastrarColaborador").withType("POST"));

		return ResponseEntity.status(HttpStatus.OK).body(entityModel);
		
	}
}
