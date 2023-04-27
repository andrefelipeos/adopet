package io.github.andrefelipeos.adopet.domain.animal;

import java.time.LocalDate;

public record DadosAtualizacaoAnimal(
		String nome,
		Sexo sexo,
		LocalDate dataDeNascimento,
		Long identificadorDoAbrigo,
		String descricao,
		Boolean adotado
) {}
