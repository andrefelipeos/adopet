package io.github.andrefelipeos.adopet.domain.adocao;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroAdocao(
		@NotNull
		Long identificadorAnimal,
		@NotNull
		Long identificadorTutor,
		@NotNull
		LocalDate data
) {}
