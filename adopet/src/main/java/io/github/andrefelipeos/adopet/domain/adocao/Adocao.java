package io.github.andrefelipeos.adopet.domain.adocao;

import java.time.LocalDate;

import io.github.andrefelipeos.adopet.domain.animal.Animal;
import io.github.andrefelipeos.adopet.domain.tutor.Tutor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Adocao")
@Table(name = "adocoes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Adocao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long identificador;

	private LocalDate data;

	@OneToOne
	@JoinColumn(name = "animal_id")
	private Animal animal;

	@OneToOne
	@JoinColumn(name = "tutor_id")
	private Tutor tutor;

}
