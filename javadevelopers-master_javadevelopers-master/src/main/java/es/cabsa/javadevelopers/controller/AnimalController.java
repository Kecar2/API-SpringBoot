package es.cabsa.javadevelopers.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.cabsa.javadevelopers.models.Animal;
import es.cabsa.javadevelopers.repositories.AnimalRepo;
import es.cabsa.javadevelopers.services.AnimalService;

@RestController
public class AnimalController {

	@Autowired
	AnimalService animalService;
	
	@Autowired
	AnimalRepo animalRepository;

	@RequestMapping(value = "/animales", method = RequestMethod.GET)
	public ResponseEntity<List<Animal>> consultaAnimal() {
		return new ResponseEntity<List<Animal>>(animalService.verAnimales(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/animales/name")
	public ResponseEntity<List<Animal>> getAnimalsByName(@RequestParam String name) {
		return new ResponseEntity<List<Animal>>(animalRepository.findByName(name), HttpStatus.OK);
	}

	@PostMapping("/animales")
	public ResponseEntity<Animal> saveAnimal(@RequestBody Animal animal) {
		return new ResponseEntity<Animal>(animalService.saveAnimal(animal), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/animales", method = RequestMethod.PUT)
	public ResponseEntity<Animal> actualizar(@RequestBody Animal animal) {
		return new ResponseEntity<Animal>(animalService.saveAnimal(animal), HttpStatus.OK);
	}

	@RequestMapping(value = "/animales/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> eliminarById(@PathVariable("id") int id) {
		Optional<Animal> animalOpcional = animalService.consultaById(id);
		if (animalOpcional.isPresent()) {
			Animal animal = animalOpcional.get();
			animalService.eliminar(animal);
			return new ResponseEntity<String>("se ha eliminado el animal", HttpStatus.OK);
		} else
			return new ResponseEntity<String>("el animal no existe", HttpStatus.OK);
	}
}
