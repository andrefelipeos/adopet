package io.github.andrefelipeos.adopet.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.andrefelipeos.adopet.domain.adocao.Adocao;
import io.github.andrefelipeos.adopet.domain.adocao.AdocaoRepository;
import io.github.andrefelipeos.adopet.domain.adocao.DadosCadastroAdocao;
import io.github.andrefelipeos.adopet.domain.animal.Animal;
import io.github.andrefelipeos.adopet.domain.animal.AnimalRepository;
import io.github.andrefelipeos.adopet.domain.tutor.Tutor;
import io.github.andrefelipeos.adopet.domain.tutor.TutorRepository;

@RestController
@RequestMapping("/adocao")
public class AdocaoController {

	@Autowired
	private AdocaoRepository adocaoRepository;

	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private TutorRepository tutorRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<Adocao> cadastrar(@RequestBody DadosCadastroAdocao dados) {
		Tutor tutor = tutorRepository.getReferenceById(dados.identificadorTutor());
		Animal animal = animalRepository.getReferenceById(dados.identificadorAnimal());
		Adocao adocao = new Adocao(null, LocalDate.from(dados.data()), animal, tutor);
		adocaoRepository.save(adocao);
		return ResponseEntity.ok(adocao);
	}

	@GetMapping
	public ResponseEntity<List<Adocao>> listar() {
		var listaDeAdocoes = adocaoRepository.findAll();
		return ResponseEntity.ok(listaDeAdocoes);
	}

	@DeleteMapping("/{identificador}")
	public void excluir(@PathVariable Long identificador) {
		adocaoRepository.deleteById(identificador);
	}

}
