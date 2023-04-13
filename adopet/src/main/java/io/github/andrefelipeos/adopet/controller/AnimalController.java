package io.github.andrefelipeos.adopet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.andrefelipeos.adopet.domain.animal.Animal;
import io.github.andrefelipeos.adopet.domain.animal.AnimalRepository;
import io.github.andrefelipeos.adopet.domain.animal.DadosCadastroAnimal;
import jakarta.validation.Valid;

@RestController
@RequestMapping("animais")
public class AnimalController {

	@Autowired
	private AnimalRepository animalRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<Animal> cadastrar(@RequestBody @Valid DadosCadastroAnimal dados) {
		Animal animal = animalRepository.save(new Animal(dados));
		return ResponseEntity.ok(animal);
	}

}
