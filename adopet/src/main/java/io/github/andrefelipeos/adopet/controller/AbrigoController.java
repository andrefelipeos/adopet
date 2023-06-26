package io.github.andrefelipeos.adopet.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.github.andrefelipeos.adopet.domain.abrigo.Abrigo;
import io.github.andrefelipeos.adopet.domain.abrigo.AbrigoRepository;
import io.github.andrefelipeos.adopet.domain.abrigo.DadosAtualizacaoAbrigo;
import io.github.andrefelipeos.adopet.domain.abrigo.DadosCadastroAbrigo;
import io.github.andrefelipeos.adopet.domain.abrigo.DadosListagemAbrigos;
import io.github.andrefelipeos.adopet.domain.abrigo.DadosVisualizacaoAbrigo;
import jakarta.validation.Valid;

@RestController
@RequestMapping("abrigos")
public class AbrigoController {

	@Autowired
	private AbrigoRepository abrigoRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<DadosVisualizacaoAbrigo> cadastrar(@RequestBody @Valid DadosCadastroAbrigo dados,
			UriComponentsBuilder uriBuilder) {
		Abrigo abrigo = abrigoRepository.save(new Abrigo(dados));
		URI uri = uriBuilder.path("/abrigos/{id}").buildAndExpand(abrigo.getIdentificador()).toUri();
		return ResponseEntity.created(uri).body(new DadosVisualizacaoAbrigo(abrigo));
	}

	@GetMapping
	public ResponseEntity<List<DadosListagemAbrigos>> listar() {
		List<Abrigo> abrigos = abrigoRepository.findAll();
		return ResponseEntity.ok(abrigos.stream().map(DadosListagemAbrigos::new).toList());
	}

	@GetMapping("/{identificador}")
	public ResponseEntity<DadosVisualizacaoAbrigo> visualizar(@PathVariable Long identificador) {
		Abrigo abrigo = abrigoRepository.getReferenceById(identificador);
		return ResponseEntity.ok(new DadosVisualizacaoAbrigo(abrigo));
	}

	@PutMapping("/{identificador}")
	@Transactional
	public ResponseEntity<DadosVisualizacaoAbrigo> atualizar(@PathVariable Long identificador,
			@RequestBody @Valid DadosAtualizacaoAbrigo dados) {
		Abrigo abrigo = abrigoRepository.getReferenceById(identificador);
		abrigo.atualizarInformacoes(dados);
		return ResponseEntity.ok(new DadosVisualizacaoAbrigo(abrigo));
	}

	@DeleteMapping("/{identificador}")
	@Transactional
	public ResponseEntity<Void> excluir(@PathVariable Long identificador) {
		abrigoRepository.deleteById(identificador);
		return ResponseEntity.noContent().build();
	}

}
