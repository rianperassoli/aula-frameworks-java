package br.com.rianperassoli.bootweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.rianperassoli.bootweb.model.Pessoa;
import br.com.rianperassoli.bootweb.regras.PessoaRegra;
import br.com.rianperassoli.bootweb.repository.CidadeRepository;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRegra pessoaRegra;
	
	@Autowired CidadeRepository cidadeRepository;

	@PostMapping("/salvar")
	public String salvar(@Valid Pessoa pessoa, BindingResult erros) {
		
		if (erros.hasErrors()) {
			return "pessoa/novo";
		}
		
		pessoaRegra.salvar(pessoa);

		return "redirect:/pessoa/listar";

	}

	@PostMapping("/alterar")
	public String alterar(@Valid Pessoa pessoa, BindingResult erros) {
		
		if (erros.hasErrors()) {
			return "pessoa/visualiza";
		}
		
		pessoaRegra.salvar(pessoa);

		return "redirect:/pessoa/listar";

	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		//Torna a lista de pessoa acessível no JSP
		model.addAttribute("pessoas", pessoaRegra.dadosGrid());

		return "pessoa/lista"; //caminho + nome do JSP que será renderizado para a tela

	}
	
	@GetMapping("/novo")
	public String novo(Model model) {
		model.addAttribute("cidades", cidadeRepository.findAll());
		
		return "/pessoa/novo";
	}

	@GetMapping("/deletar/{codigo}")
	public String deletar(@PathVariable("codigo") Long codigo) {
		pessoaRegra.delete(new Pessoa(codigo));

		return "redirect:pessoa/listar";
	}
	
	@GetMapping("/visualiza/{codigo}")
	public String visualizar(@PathVariable("codigo") Long codigo, Model model) {
		
		model.addAttribute("cidades", cidadeRepository.findAll());
		model.addAttribute("pessoa", pessoaRegra.buscarPorCodigo(codigo));
		
		return "/pessoa/visualiza";
	}
	
	
	
	
	

	@GetMapping("/listar/nome/{nome}")
	@ResponseBody
	public List<Pessoa> listarPorNome(@PathVariable("nome") String nome) {

		return pessoaRegra.listarPorNome(nome);

	}

	@GetMapping("/listar/cpf/{cpf}")
	@ResponseBody
	public List<Pessoa> listarPorCpf(@PathVariable("cpf") String cpf) {

		return pessoaRegra.listarPorCpf(cpf);

	}
}
