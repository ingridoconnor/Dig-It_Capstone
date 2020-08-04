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

	@RequestMapping(path = { "/allPlants/"}, method = RequestMethod.GET)
	public List<Plant> listAllPlants() {
		List<Plant> allPlants = thePlants.getAllPlants();
		return allPlants;
	}
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

}
