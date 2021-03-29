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

import br.com.eduguimar.vaccine.domain.GrupoPrioritario;
import br.com.eduguimar.vaccine.repository.GruposPrioritariosRepository;

@RestController
@RequestMapping("/grupos")
public class GruposPrioritariosResource {
	
	@Autowired
	private GruposPrioritariosRepository gruposPrioritariosRepository;
	
	@GetMapping
	public List<GrupoPrioritario> listarGrupos() {
		return gruposPrioritariosRepository.findAll();
	}
	
	@PostMapping
	public GrupoPrioritario cadastrarGrupo(@RequestBody GrupoPrioritario grupoPrioritario) {
		return gruposPrioritariosRepository.save(grupoPrioritario);
	}
	
	@PutMapping("/{codigo}")
	public GrupoPrioritario atualizarGrupo(@PathVariable("codigo") Long codigo,@RequestBody GrupoPrioritario grupoPrioritario) {
		return gruposPrioritariosRepository.findById(codigo).map(
				record -> {
					  record.setNome(grupoPrioritario.getNome());
					  record.setDescricao(grupoPrioritario.getDescricao());
					  return gruposPrioritariosRepository.save(record);
				}).orElse(null);
	}
	
	@GetMapping("/{codigo}")
	public GrupoPrioritario buscarGrupo(@PathVariable("codigo") Long codigo) {
		return gruposPrioritariosRepository.findById(codigo).orElse(null);
	}
	

}
