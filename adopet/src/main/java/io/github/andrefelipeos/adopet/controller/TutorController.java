package io.github.andrefelipeos.adopet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.andrefelipeos.adopet.domain.tutor.DadosCadastroTutor;
import io.github.andrefelipeos.adopet.domain.tutor.Tutor;
import io.github.andrefelipeos.adopet.domain.tutor.TutorRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("tutores")
public class TutorController {

	@Autowired
	private TutorRepository tutorRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<Tutor> cadastrar(@RequestBody @Valid DadosCadastroTutor dados) {
		Tutor tutor = tutorRepository.save(new Tutor(dados));
		return ResponseEntity.ok(tutor);
	}

}
