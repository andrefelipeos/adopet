package io.github.andrefelipeos.adopet.domain.abrigo;

public record DadosListagemAbrigos(
		Long identificador,
		String nome,
		String cidade,
		String descricao
) {

	public DadosListagemAbrigos(Abrigo abrigo) {
		this(abrigo.getIdentificador(),	abrigo.getNome(), abrigo.getEndereco().getCidade(), abrigo.getDescricao());
	}

}
