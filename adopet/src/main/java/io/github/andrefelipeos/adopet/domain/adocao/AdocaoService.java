package io.github.andrefelipeos.adopet.domain.adocao;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.andrefelipeos.adopet.domain.animal.Animal;
import io.github.andrefelipeos.adopet.domain.animal.AnimalRepository;
import io.github.andrefelipeos.adopet.domain.tutor.Tutor;
import io.github.andrefelipeos.adopet.domain.tutor.TutorRepository;

@Service
public class AdocaoService {

	@Autowired
	private AdocaoRepository adocaoRepository;

	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private TutorRepository tutorRepository;

	public Adocao registrarNovaAdoção(Long idTutor, Long idAnimal, LocalDate data) {
		Tutor tutor = tutorRepository.getReferenceById(idTutor);
		Animal animal = animalRepository.getReferenceById(idAnimal);
		Adocao adocao = new Adocao(null, LocalDate.from(data), animal, tutor);
		adocaoRepository.save(adocao);
		animal.setAdotado(true);
		return adocao;
	}
}
