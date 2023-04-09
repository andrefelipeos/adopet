package io.github.andrefelipeos.adopet.domain.abrigo;

import io.github.andrefelipeos.adopet.domain.endereco.Endereco;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Abrigo")
@Table(name = "abrigos")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "identificador")
@Getter
public class Abrigo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long identificador;

	private String nome;
	private String email;
	private String telefone;
	private String descricao;

	@Embedded
	private Endereco endereco;

	public Abrigo(DadosCadastroAbrigo dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.descricao = dados.descricao();
		this.endereco = new Endereco(dados.endereco());
	}

	public void atualizarInformacoes(DadosAtualizacaoAbrigo dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.email() != null) {
			this.email = dados.email();
		}
		if (dados.telefone() != null) {
			this.telefone = dados.telefone();
		}
		if (dados.descricao() != null) {
			this.descricao = dados.descricao();
		}
		if (dados.endereco() != null) {
			this.endereco.atualizarInformacoes(dados.endereco());
		}
	}

}
