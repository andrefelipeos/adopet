package io.github.andrefelipeos.adopet.domain.tutor;

public record DadosListagemTutores(
		String nome,
		String cidade,
		String biografia
) {

	public DadosListagemTutores(Tutor tutor) {
		this(tutor.getNome(), tutor.getCidade(), tutor.getBiografia());
	}

}
