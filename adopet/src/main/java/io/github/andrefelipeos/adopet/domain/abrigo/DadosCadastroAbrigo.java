package io.github.andrefelipeos.adopet.domain.abrigo;

import io.github.andrefelipeos.adopet.domain.endereco.DadosCadastroEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAbrigo(
		@NotBlank
		String nome,
		@NotBlank
		@Email
		String email,
		@NotBlank
		String telefone,
		String descricao,
		@NotNull
		@Valid
		DadosCadastroEndereco endereco
) {}
