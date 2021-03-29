package br.com.eduguimar.vaccine.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eduguimar.vaccine.domain.Pessoa;
import br.com.eduguimar.vaccine.repository.PessoaRepository;


@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping
	public List<Pessoa> listarPessoas() {
		return pessoaRepository.findAll();
	}
	
	@PostMapping
	public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@PutMapping("/{codigo}")
	public Pessoa atualizarPessoa(@PathVariable("codigo") Long codigo, @RequestBody Pessoa pessoa) {
		  return pessoaRepository.findById(codigo).map(
				  record -> {
					  record.setNome(pessoa.getNome());
					  record.setCpf(pessoa.getCpf());
					  record.setIdade(pessoa.getIdade());
					  record.setDataNascimento(pessoa.getDataNascimento());
					  record.setEmail(pessoa.getEmail());
					  record.setTelefone(pessoa.getTelefone());
					  record.setIsVacinada(pessoa.getIsVacinada());
					  return pessoaRepository.save(record);
				  }).orElse(null);
	}
	
	@GetMapping("/{codigo}")
	public Pessoa buscarPessoa(@PathVariable("codigo") Long codigo) {
		return pessoaRepository.findById(codigo).orElse(null);
	}

}
