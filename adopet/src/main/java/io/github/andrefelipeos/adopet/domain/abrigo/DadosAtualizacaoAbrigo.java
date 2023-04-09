package io.github.andrefelipeos.adopet.domain.abrigo;

import io.github.andrefelipeos.adopet.domain.endereco.DadosAtualizacaoEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;

public record DadosAtualizacaoAbrigo(
		String nome,
		@Email
		String email,
		String telefone,
		String descricao,
		@Valid
		DadosAtualizacaoEndereco endereco
) {}
