package es.cabsa.javadevelopers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cabsa.javadevelopers.models.Animal;
import es.cabsa.javadevelopers.repositories.AnimalRepo;

@Service
public class AnimalServiceImpl extends AnimalService {
	
	@Autowired
	private AnimalRepo animalRepository;
	
	@Override
	public List<Animal> verAnimales() {
		return animalRepository.findAll();
	}

}
