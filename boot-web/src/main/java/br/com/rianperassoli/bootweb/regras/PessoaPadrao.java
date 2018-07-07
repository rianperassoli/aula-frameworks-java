package br.com.rianperassoli.bootweb.regras;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rianperassoli.bootweb.model.Pessoa;
import br.com.rianperassoli.bootweb.repository.PessoaRepository;

@Service
public class PessoaPadrao implements PessoaRegra {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public void salvar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}

	@Override
	public void delete(Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
	}

	@Override
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}

	@Override
	public List<Pessoa> listarPorNome(String nome) {
		return pessoaRepository.findByNomeLike("%"+nome+"%");
	}

	@Override
	public List<Pessoa> listarPorCpf(String cpf) {
		return pessoaRepository.porCPF(cpf);
	}

}
