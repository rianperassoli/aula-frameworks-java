package br.com.rianperassoli.bootweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.rianperassoli.bootweb.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	List<Pessoa> findByNomeLike(String Nome);
	
	@Query("select p from Pessoa p where p.cpf = :cpf")
	List<Pessoa> porCPF(@Param("cpf") String cpf);
}
