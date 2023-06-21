package io.github.andrefelipeos.adopet.domain.tutor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity(name = "Tutor")
@Table(name = "tutores")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "identificador")
@Getter
public class Tutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long identificador;

	private String nome;
	private String email;
	private String telefone;
	private String cidade;
	private String biografia;
	private String senha;

	public Tutor(DadosCadastroTutor dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.cidade = dados.cidade();
		this.biografia = dados.biografia();
		this.senha = dados.senha();
	}

	public void atualizarInformacoes(DadosAtualizacaoTutor dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.email() != null) {
			this.email = dados.email();
		}
		if (dados.telefone() != null) {
			this.telefone = dados.telefone();
		}
		if (dados.cidade() != null) {
			this.cidade = dados.cidade();
		}
		if (dados.biografia() != null) {
			this.biografia = dados.biografia();
		}
		if (dados.senha() != null) {
			this.senha = dados.senha();
		}
	}

}
