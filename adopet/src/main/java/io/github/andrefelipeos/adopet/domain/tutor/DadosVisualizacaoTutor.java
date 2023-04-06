package io.github.andrefelipeos.adopet.domain.tutor;

public record DadosVisualizacaoTutor(
		Long identificador,
		String nome,
		String email,
		String telefone,
		String cidade,
		String biografia
) {

	public DadosVisualizacaoTutor(Tutor tutor) {
		this(
				tutor.getIdentificador(),
				tutor.getNome(),
				tutor.getEmail(),
				tutor.getTelefone(),
				tutor.getCidade(),
				tutor.getBiografia()
			);
	}

}
