package br.com.politica.controller;

import java.net.URI;
import java.util.List;
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

import br.com.politica.controller.dto.PartidoDto;
import br.com.politica.controller.form.AtualizacaoPartidoForm;
import br.com.politica.controller.form.PartidoForm;
import br.com.politica.modelo.Ideologia;
import br.com.politica.modelo.Partido;
import br.com.politica.repository.PartidoRepository;

@RestController
@RequestMapping(value = "/partidos")
public class PartidosController {

	@Autowired
	private PartidoRepository partidoRepository;

	@GetMapping
	@Cacheable(value = "listaDePartidos")
	public List<PartidoDto> listarPartidos(String nomePartido) {

		List<Partido> partidos = partidoRepository.acharPorNomeDoPartido(nomePartido);
		return PartidoDto.converter(partidos);
	}

	@GetMapping("/ideologia")
	@Cacheable(value = "listaDePartidos")
	public List<PartidoDto> listarPartidosPorIdeologia(Ideologia ideologia) {

		List<Partido> partidos = partidoRepository.acharPorIdeologiaDoPartido(ideologia);
		return PartidoDto.converter(partidos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PartidoDto> detalhar(@PathVariable Long id) {
		Optional<Partido> optional = partidoRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new PartidoDto(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDePartidos", allEntries = true)
	public ResponseEntity<PartidoDto> cadastrar(@RequestBody @Valid PartidoForm form, UriComponentsBuilder uriBuilder) {
		Partido partido = form.converter(partidoRepository);
		partidoRepository.save(partido);

		URI uri = uriBuilder.path("/partidos/{id}").buildAndExpand(partido.getId()).toUri();
		return ResponseEntity.created(uri).body(new PartidoDto(partido));
	}

	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDePartidos", allEntries = true)
	public ResponseEntity<PartidoDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoPartidoForm form) {
		Optional<Partido> optional = partidoRepository.findById(id);
		if (optional.isPresent()) {
			Partido partido = form.atualizar(id, partidoRepository);
			return ResponseEntity.ok(new PartidoDto(partido));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDePartidos", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Partido> optional = partidoRepository.findById(id);
		if (optional.isPresent()) {
			partidoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
