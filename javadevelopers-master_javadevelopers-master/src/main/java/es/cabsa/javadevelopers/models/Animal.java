package es.cabsa.javadevelopers.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Animals")
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "legs")
	private Long legs;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idfood", referencedColumnName = "id")
	private Food food;
	
	public Animal() {
 
	}

	public Animal(Long id, String name, Long legs, String foods, Food food) {
		super();
		this.id = id;
		this.name = name;
		this.legs = legs;
		this.food = food;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getLegs() {
		return legs;
	}

	public void setLegs(Long legs) {
		this.legs = legs;
	}
	
	

}
