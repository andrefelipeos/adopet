package io.github.andrefelipeos.adopet.domain.endereco;

import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoEndereco(
		@Pattern(regexp = "\\d{8}")
		String cep,
		String cidade,
		String bairro,
		String logradouro,
		Integer numero,
		String complemento
) {}
