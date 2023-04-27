package io.github.andrefelipeos.adopet.domain.animal;

import java.time.LocalDate;
import java.time.Period;

import io.github.andrefelipeos.adopet.domain.abrigo.Abrigo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Animal")
@Table(name = "animais")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long identificador;

	private String nome;
	private String descricao;
	private Boolean adotado;

	@Column(name = "data_nasc")
	private LocalDate dataDeNascimento;

	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "abrigo_id")
	private Abrigo abrigo;

	public Animal(DadosCadastroAnimal dados, Abrigo abrigo) {
		this.nome = dados.nome();
		this.descricao = dados.descricao();
		this.adotado = dados.adotado();
		this.dataDeNascimento = dados.dataDeNascimento();
		this.sexo = dados.sexo();
		this.abrigo = abrigo;
	}

	public String idadePorExtenso() {
		StringBuilder idade = new StringBuilder();
		int mesesTotais = Period.between(dataDeNascimento, LocalDate.now()).getMonths();
		int anos = mesesTotais / 12;
		int meses = mesesTotais % 12;
		if (anos > 0) {
			idade.append(anos);
			idade.append(" ano");
			if (anos > 1) {
				idade.append("s");
			}
		}
		if (meses > 0) {
			idade.append(meses);
			if (anos == 1) {
				idade.append(" mês");
			} else {
				idade.append(" meses");
			}
		}
		if (anos == 0 && meses == 0) {
			idade.append("recém-nascido");
		}
		return null;
	}

	public void atualizarInformacoes(DadosAtualizacaoAnimal dados, Abrigo abrigo) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.sexo() != null) {
			this.sexo = dados.sexo();
		}
		if (dados.dataDeNascimento() != null) {
			this.dataDeNascimento = dados.dataDeNascimento();
		}
		if (abrigo != null) {
			this.abrigo = abrigo;
		}
		if (dados.descricao() != null) {
			this.descricao = dados.descricao();
		}
		if (dados.adotado() != null) {
			this.adotado = dados.adotado();
		}
	}

}
