package io.github.andrefelipeos.adopet.domain.tutor;

public record DadosListagemTutores(
		Long identificador,
		String nome,
		String cidade,
		String biografia
) {

	public DadosListagemTutores(Tutor tutor) {
		this(tutor.getIdentificador(), tutor.getNome(), tutor.getCidade(), tutor.getBiografia());
	}

}
