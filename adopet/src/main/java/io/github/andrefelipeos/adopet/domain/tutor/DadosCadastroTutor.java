package io.github.andrefelipeos.adopet.domain.tutor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTutor(
		@NotBlank
		String nome,
		@NotBlank
		@Email
		String email,
		@NotBlank
		String telefone,
		@NotBlank
		String cidade,
		String biografia,
		@NotBlank
		String senha
) {}
