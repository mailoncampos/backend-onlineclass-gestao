package br.com.apionlineclassgestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apionlineclassgestao.model.DadosPessoais;

@Repository
public interface DadosPessoaisRepository extends JpaRepository<DadosPessoais, Long>{

}
