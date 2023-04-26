package io.github.andrefelipeos.adopet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.andrefelipeos.adopet.domain.abrigo.Abrigo;
import io.github.andrefelipeos.adopet.domain.abrigo.AbrigoRepository;
import io.github.andrefelipeos.adopet.domain.animal.Animal;
import io.github.andrefelipeos.adopet.domain.animal.AnimalRepository;
import io.github.andrefelipeos.adopet.domain.animal.DadosCadastroAnimal;
import io.github.andrefelipeos.adopet.domain.animal.DadosListagemAnimais;
import io.github.andrefelipeos.adopet.domain.animal.DadosVisualizacaoAnimal;
import jakarta.validation.Valid;

@RestController
@RequestMapping("animais")
public class AnimalController {

	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private AbrigoRepository abrigoRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<Animal> cadastrar(@RequestBody @Valid DadosCadastroAnimal dados) {
		Abrigo abrigo = abrigoRepository.findById(dados.identificadorDoAbrigo()).get();
		Animal animal = animalRepository.save(new Animal(dados, abrigo));
		return ResponseEntity.ok(animal);
	}

	@GetMapping
	public ResponseEntity<List<DadosListagemAnimais>> listar() {
		List<Animal> animais = animalRepository.findAll();
		return ResponseEntity.ok(animais.stream().map(DadosListagemAnimais::new).toList());
	}

	@GetMapping("/{identificador}")
	public ResponseEntity<DadosVisualizacaoAnimal> visualizar(@PathVariable Long identificador) {
		Animal animal = animalRepository.getReferenceById(identificador);
		return ResponseEntity.ok(new DadosVisualizacaoAnimal(animal));
	}

}
