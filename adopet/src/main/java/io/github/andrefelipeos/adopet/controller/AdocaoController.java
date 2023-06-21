package io.github.andrefelipeos.adopet.controller;

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
import io.github.andrefelipeos.adopet.domain.adocao.AdocaoService;
import io.github.andrefelipeos.adopet.domain.adocao.DadosCadastroAdocao;

@RestController
@RequestMapping("/adocoes")
public class AdocaoController {

	@Autowired
	private AdocaoService adocaoService;

	@Autowired
	private AdocaoRepository adocaoRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<Adocao> cadastrar(@RequestBody DadosCadastroAdocao dados) {
		Adocao adocao = adocaoService
				.registrarNovaAdoção(dados.identificadorTutor(), dados.identificadorAnimal(), dados.data());
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
