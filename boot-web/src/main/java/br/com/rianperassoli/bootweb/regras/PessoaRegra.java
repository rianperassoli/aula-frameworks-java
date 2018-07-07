package br.com.rianperassoli.bootweb.regras;

import java.util.List;

import br.com.rianperassoli.bootweb.model.Pessoa;

public interface PessoaRegra {
	
	public void salvar(Pessoa pessoa);

	public void delete(Pessoa pessoa);

	public List<Pessoa> listar();
	
	List<Pessoa> listarPorNome(String nome);
	
	List<Pessoa> listarPorCpf(String cpf);
	
}
