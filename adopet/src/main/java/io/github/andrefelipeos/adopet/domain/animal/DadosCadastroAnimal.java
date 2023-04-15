package io.github.andrefelipeos.adopet.domain.animal;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAnimal(
		@NotBlank
		String nome,
		@NotNull
		LocalDate dataDeNascimento,
		String descricao,
		@NotNull
		Boolean adotado
) {}
