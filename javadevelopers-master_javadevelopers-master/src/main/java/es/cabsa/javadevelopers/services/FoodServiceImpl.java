package es.cabsa.javadevelopers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cabsa.javadevelopers.models.Food;
import es.cabsa.javadevelopers.repositories.FoodRepo;

@Service
public class FoodServiceImpl extends FoodService{
	
	
	@Autowired
	private FoodRepo comidaRepository;
	
	@Override
	public Food saveFood(Food food) {
		return comidaRepository.save(food);
	}
}
