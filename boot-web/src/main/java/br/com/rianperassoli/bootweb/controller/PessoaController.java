package br.com.rianperassoli.bootweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.rianperassoli.bootweb.model.Pessoa;
import br.com.rianperassoli.bootweb.regras.PessoaRegra;
import br.com.rianperassoli.bootweb.repository.PessoaRepository;

@Controller
public class PessoaController {

	@Autowired
	private PessoaRegra pessoaRegra;
	
	@GetMapping("/pessoa/salvar")
	@ResponseBody
	public String salvar() {

		Pessoa pessoa = new Pessoa("Rian Perassoli", "213341421");

		pessoaRegra.salvar(pessoa);

		return "Salvo com  sucesso";

	}

	@GetMapping("/pessoa/listar")
	@ResponseBody
	public List<Pessoa> listar() {

		return pessoaRegra.listar();

	}

	@GetMapping("/pessoa/deletar")
	@ResponseBody
	public String deletar() {
		Pessoa pessoa = new Pessoa(1L);
		pessoaRegra.delete(pessoa);
		
		return "pessoa deletada";
	}
	
	@GetMapping("/pessoa/listar/nome/{nome}")
	@ResponseBody
	public List<Pessoa> listarPorNome(@PathVariable("nome") String nome) {

		return pessoaRegra.listarPorNome(nome);

	}
	
	@GetMapping("/pessoa/listar/cpf/{cpf}")
	@ResponseBody
	public List<Pessoa> listarPorCpf(@PathVariable("cpf") String cpf) {

		return pessoaRegra.listarPorCpf(cpf);

	}
}
