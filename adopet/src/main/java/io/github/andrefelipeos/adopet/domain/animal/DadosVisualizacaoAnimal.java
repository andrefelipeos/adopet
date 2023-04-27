package io.github.andrefelipeos.adopet.domain.animal;

import java.time.LocalDate;

import io.github.andrefelipeos.adopet.domain.endereco.Endereco;

public record DadosVisualizacaoAnimal(
		Long identificador,
		String nome,
		Sexo sexo,
		LocalDate dataDeNascimento,
		String nomeDoAbrigo,
		Endereco endereco,
		String descricao) {

	public DadosVisualizacaoAnimal(Animal animal) {
		this(animal.getIdentificador(), animal.getNome(), animal.getSexo(), animal.getDataDeNascimento(),
				animal.getAbrigo().getNome(), animal.getAbrigo().getEndereco(), animal.getDescricao());
	}

}
