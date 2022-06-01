package es.cabsa.javadevelopers.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.cabsa.javadevelopers.models.Animal;
import es.cabsa.javadevelopers.models.Food;

@Repository
public interface FoodRepo extends JpaRepository<Food, Long> {
	
	List<Food>findByName(String nombre);

}
