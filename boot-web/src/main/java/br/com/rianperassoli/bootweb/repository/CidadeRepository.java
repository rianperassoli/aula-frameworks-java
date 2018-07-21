package br.com.rianperassoli.bootweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rianperassoli.bootweb.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
}
