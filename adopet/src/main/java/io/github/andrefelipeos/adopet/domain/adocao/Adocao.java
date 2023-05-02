package io.github.andrefelipeos.adopet.domain.adocao;

import java.time.LocalDate;

import io.github.andrefelipeos.adopet.domain.animal.Animal;
import io.github.andrefelipeos.adopet.domain.tutor.Tutor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private Long identificador;

	private LocalDate data;
	private Animal animal;
	private Tutor tutor;

}
