package br.com.politica.controller;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.politica.controller.dto.AssociadoDto;
import br.com.politica.controller.form.AssociadoForm;
import br.com.politica.controller.form.AtualizacaoAssociadosForm;
import br.com.politica.modelo.Associado;
import br.com.politica.modelo.CargoPolitico;
import br.com.politica.repository.AssociadoRepository;
import br.com.politica.repository.PartidoRepository;

@RestController
@RequestMapping(value = "/associados")
public class AssociadosController {

	@Autowired
	private AssociadoRepository associadoRepository;

	@Autowired
	private PartidoRepository partidoRepository;
	
	@Autowired
	public AssociadosController(AssociadoRepository associadoRepository) {
		this.associadoRepository = associadoRepository;
	}

	@GetMapping
	@Cacheable(value = "listaDeAssociados")
	public List<AssociadoDto> lista(String nomeAssociado) {
		if (Objects.isNull(nomeAssociado)) {
			List<Associado> associados = associadoRepository.findAll();
			return AssociadoDto.converter(associados);
		} else {
			List<Associado> associados = associadoRepository.findByNomeAssociado(nomeAssociado);
			return AssociadoDto.converter(associados);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<AssociadoDto> detalhar(@PathVariable Long id) {
		Optional<Associado> optional = associadoRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new AssociadoDto(optional.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/cargo")
	@Cacheable(value = "listaDeAssociados")
	public List<AssociadoDto> listarPorCargo(CargoPolitico cargo) {

		List<Associado> associados = associadoRepository.findByCargo(cargo);
		return AssociadoDto.converter(associados);
	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeAssociados", allEntries = true)
	public ResponseEntity<AssociadoDto> cadastrar(@RequestBody @Valid AssociadoForm form,
			UriComponentsBuilder uriBuilder) {
		Associado associado = form.converter(partidoRepository);
		associadoRepository.save(associado);

		URI uri = uriBuilder.path("/associados/{id}").buildAndExpand(associado.getId()).toUri();
		return ResponseEntity.created(uri).body(new AssociadoDto(associado));
	}

	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeAssociados", allEntries = true)
	public ResponseEntity<AssociadoDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoAssociadosForm form) {
		Optional<Associado> optional = associadoRepository.findById(id);
		if (optional.isPresent()) {
			Associado associado = form.atualizar(id, associadoRepository);
			return ResponseEntity.ok(new AssociadoDto(associado));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeAssociados", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Associado> optional = associadoRepository.findById(id);
		if (optional.isPresent()) {
			associadoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
