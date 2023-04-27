package io.github.andrefelipeos.adopet.domain.animal;

import java.time.LocalDate;

public record DadosListagemAnimais(
		Long identificador,
		String nome,
		Sexo sexo,
		LocalDate dataDeNascimento,
		String nomeDoAbrigo,
		String descricao) {

	public DadosListagemAnimais(Animal animal) {
		this(animal.getIdentificador(), animal.getNome(), animal.getSexo(), animal.getDataDeNascimento(),
				animal.getAbrigo().getNome(), animal.getDescricao());
	}

}
