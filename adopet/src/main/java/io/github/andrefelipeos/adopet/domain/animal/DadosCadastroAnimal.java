package io.github.andrefelipeos.adopet.domain.animal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAnimal(
		@NotBlank
		String nome,
		String descricao,
		@NotNull
		Boolean adotado
) {}
