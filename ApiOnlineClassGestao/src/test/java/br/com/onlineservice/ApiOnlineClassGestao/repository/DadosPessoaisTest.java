package br.com.onlineservice.ApiOnlineClassGestao.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import br.com.apionlineclassgestao.model.DadosPessoais;
import br.com.apionlineclassgestao.repository.DadosPessoaisRepository;
import br.com.onlineservice.ApiOnlineClassGestao.ConfigTest;

@ContextConfiguration
public class DadosPessoaisTest extends ConfigTest{

//	@Autowired
//	private DadosPessoaisService dadosPessoaisService;	
	@Autowired
	private DadosPessoaisRepository dadosPessoaisRepository;
//	@BeforeEach
//	public void setUp() {
//		RestAssuredMock
//	}
	@Test
	public void testeCriarDadosPessoais() {
		List<DadosPessoais> dadosPessoais = dadosPessoaisRepository.findAll();
//		DadosPessoais dadosPessoais = new DadosPessoais("Mailon Bruno", "04999998774", LocalDate.of(1999, 4, 21));
//		DadosPessoais dadosPessoaisSalvo = dadosPessoaisService.salvarDadosPessoais(dadosPessoais);
		Assertions.assertNotNull(dadosPessoais);
	}
}
