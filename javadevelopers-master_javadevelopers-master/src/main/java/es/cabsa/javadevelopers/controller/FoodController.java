package es.cabsa.javadevelopers.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.cabsa.javadevelopers.models.Animal;
import es.cabsa.javadevelopers.models.Food;
import es.cabsa.javadevelopers.repositories.FoodRepo;
import es.cabsa.javadevelopers.services.FoodService;

@Controller
@RestController
public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@Autowired
	private FoodRepo foodRepository;

	@RequestMapping(value = "/foods", method = RequestMethod.GET)
	public ResponseEntity<List<Food>> consultaFood() {
		return new ResponseEntity<List<Food>>(foodService.consulta(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/foods/nombre")
	public ResponseEntity<List<Food>> getFoodsByName(@RequestParam String nombre) {
		return new ResponseEntity<List<Food>>(foodRepository.findByName(nombre), HttpStatus.OK);
	}

	@PostMapping("/animale")
	public ResponseEntity<Food> saveFood(@RequestBody Food food) {
		return new ResponseEntity<Food>(foodService.saveFood(food), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/foods", method = RequestMethod.PUT)
	public ResponseEntity<Food> actualizar(@RequestBody Food food) {
		return new ResponseEntity<Food>(foodService.saveFood(food), HttpStatus.OK);
	}

	@RequestMapping(value = "/foods/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> eliminarPorId(@PathVariable("id") long id) {
		Optional<Food> foodOpt = foodService.consultaById(id);
		if (foodOpt.isPresent()) {
			Food food = foodOpt.get();
			foodService.eliminar(food);
			return new ResponseEntity<String>("comida eliminada", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("esta comida no existe", HttpStatus.OK);
		}
	}

}
