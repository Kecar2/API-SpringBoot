package es.cabsa.javadevelopers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cabsa.javadevelopers.models.Animal;
import es.cabsa.javadevelopers.repositories.AnimalRepo;

@Service
public class AnimalService {

	@Autowired
	AnimalRepo animalRepository;

	public List<Animal> verAnimales() {
		return animalRepository.findAll();
	}

	public Optional<Animal> consultaById(long id) {
		return animalRepository.findById(id);
	}

	public void eliminar(Animal c) {
		animalRepository.delete(c);
	}

	public Animal saveAnimal(Animal animal) {
		return animalRepository.save(animal);
	}

}
