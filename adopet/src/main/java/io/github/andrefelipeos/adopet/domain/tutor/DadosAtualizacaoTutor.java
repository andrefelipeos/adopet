package io.github.andrefelipeos.adopet.domain.tutor;

import jakarta.validation.constraints.Email;

public record DadosAtualizacaoTutor(
		Long identificador,
		String nome,
		@Email
		String email,
		String telefone,
		String cidade,
		String biografia,
		String senha
) {}
