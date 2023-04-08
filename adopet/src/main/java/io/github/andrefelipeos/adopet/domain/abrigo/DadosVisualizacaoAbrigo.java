package io.github.andrefelipeos.adopet.domain.abrigo;

public record DadosVisualizacaoAbrigo(
		Long identificador,
		String nome,
		String email,
		String telefone,
		String cep,
		String cidade,
		String logradouro,
		Integer numero,
		String complemento,
		String decricao
) {

	public DadosVisualizacaoAbrigo(Abrigo abrigo) {
		this(
				abrigo.getIdentificador(),
				abrigo.getNome(),
				abrigo.getEmail(),
				abrigo.getTelefone(),
				abrigo.getEndereco().getCep(),
				abrigo.getEndereco().getCidade(),
				abrigo.getEndereco().getLogradouro(),
				abrigo.getEndereco().getNumero(),
				abrigo.getEndereco().getComplemento(),
				abrigo.getDescricao()
			);
	}

}
