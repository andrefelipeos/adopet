package io.github.andrefelipeos.adopet.controller;

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

import io.github.andrefelipeos.adopet.domain.tutor.DadosAtualizacaoTutor;
import io.github.andrefelipeos.adopet.domain.tutor.DadosCadastroTutor;
import io.github.andrefelipeos.adopet.domain.tutor.DadosListagemTutores;
import io.github.andrefelipeos.adopet.domain.tutor.DadosVisualizacaoTutor;
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

	@GetMapping
	public ResponseEntity<List<DadosListagemTutores>> listar() {
		List<Tutor> tutores = tutorRepository.findAll();
		return ResponseEntity.ok(tutores.stream().map(DadosListagemTutores::new).toList());
	}

	@GetMapping("/{identificador}")
	public ResponseEntity<DadosVisualizacaoTutor> visualizar(@PathVariable Long identificador) {
		Tutor tutor = tutorRepository.getReferenceById(identificador);
		return ResponseEntity.ok(new DadosVisualizacaoTutor(tutor));
	}

	@PutMapping("/{identificador}")
	@Transactional
	public ResponseEntity<DadosVisualizacaoTutor> atualizar(@PathVariable Long identificador,
			@RequestBody DadosAtualizacaoTutor dados) {
		Tutor tutor = tutorRepository.getReferenceById(identificador);
		tutor.atualizarInformacoes(dados);
		return ResponseEntity.ok(new DadosVisualizacaoTutor(tutor));
	}

	@DeleteMapping("/{identificador}")
	@Transactional
	public void excluir(@PathVariable Long identificador) {
		tutorRepository.deleteById(identificador);
	}

}
