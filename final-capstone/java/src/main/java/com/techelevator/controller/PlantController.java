package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.PlantDAO;
import com.techelevator.model.Plant;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PlantController {
	@Autowired
	PlantDAO thePlants;

<<<<<<< HEAD
	@RequestMapping(path = { "/allPlants/"}, method = RequestMethod.GET)
=======
	@Autowired
	PlantDAO thePlants;
	
	@RequestMapping(path = { "/allPlants", "/" })
>>>>>>> 7e5950a4f9c112cb3748ed64529e0cdd149219fd
	public List<Plant> listAllPlants() {
		List<Plant> allPlants = thePlants.getAllPlants();
		return allPlants;
	}
<<<<<<< HEAD
	@RequestMapping(path = {"/plantNameSearch/"}, method = RequestMethod.GET)
	public Plant searchByName() {
		Plant searchByNameResult = thePlants.searchPlantByPlantName();
		return searchByNameResult;
	}
//	@RequestMapping(path= {"/addPlant/"}, method = RequestMethod.POST)
//	public Plant addNewPlant(Plant plant) {
//		Plant addPlant = thePlants.addNewPlant(plant);
//		return addPlant;
//	}

=======
>>>>>>> 7e5950a4f9c112cb3748ed64529e0cdd149219fd
}
