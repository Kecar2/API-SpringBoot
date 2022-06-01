package es.cabsa.javadevelopers.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import es.cabsa.javadevelopers.models.Animal;

public interface AnimalRepo extends JpaRepository<Animal, Long>{
	
	List<Animal> findByName(String name);

}
