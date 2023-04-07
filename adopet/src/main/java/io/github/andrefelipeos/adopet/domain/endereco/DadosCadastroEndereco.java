package io.github.andrefelipeos.adopet.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEndereco(
		@NotBlank
		@Pattern(regexp = "\\d{8}")
		String cep,
		@NotBlank
		String cidade,
		@NotBlank
		String bairro,
		@NotBlank
		String logradouro,
		Integer numero,
		String complemento
) {}
