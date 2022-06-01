package es.cabsa.javadevelopers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cabsa.javadevelopers.models.Food;
import es.cabsa.javadevelopers.repositories.FoodRepo;

@Service
public class FoodService {

	@Autowired
	private FoodRepo comidaRepository;

	public List<Food> consulta() {
		return comidaRepository.findAll();
	}

	public Optional<Food> consultaById(long id) {
		return comidaRepository.findById(id);
	}

	public Food saveFood(Food food) {
		return comidaRepository.save(food);
	}

	public void eliminar(Food food) {
		comidaRepository.delete(food);
	}



}
