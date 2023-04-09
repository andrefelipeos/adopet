package io.github.andrefelipeos.adopet.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Endereco {

	private String cep;
	private String cidade;
	private String bairro;
	private String logradouro;
	private Integer numero;
	private String complemento;

	public Endereco(DadosCadastroEndereco dados) {
		this.cep = dados.cep();
		this.cidade = dados.cidade();
		this.bairro = dados.bairro();
		this.logradouro = dados.logradouro();
		this.numero = dados.numero();
		this.complemento = dados.complemento();
	}

	public void atualizarInformacoes(DadosAtualizacaoEndereco dados) {
		if (dados.cep() != null) {
			this.cep = dados.cep();
		}
		if (dados.cidade() != null) {
			this.cidade = dados.cidade();
		}
		if (dados.bairro() != null) {
			this.bairro = dados.bairro();
		}
		if (dados.logradouro() != null) {
			this.logradouro = dados.logradouro();
		}
		if (dados.numero() != null) {
			this.numero = dados.numero();
		}
		if (dados.complemento() != null) {
			this.complemento = dados.complemento();
		}
	}

}
