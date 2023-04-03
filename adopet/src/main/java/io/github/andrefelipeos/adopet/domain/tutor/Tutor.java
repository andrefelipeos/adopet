package io.github.andrefelipeos.adopet.domain.tutor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

}