package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.PlantDAO;
import com.techelevator.model.LineItem;
import com.techelevator.model.Plant;
import com.techelevator.model.Plot;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PlantController {
	@Autowired
	PlantDAO thePlants;


	@RequestMapping(path = { "/allPlants"}, method = RequestMethod.GET)
	public Plant[] listAllPlants() {
		List<Plant> allPlants = thePlants.getAllPlants();
		Plant[] plants = new Plant[allPlants.size()];
		plants = allPlants.toArray(plants);
		return plants;
	}

	@RequestMapping(path = {"/plantNameSearch/"}, method = RequestMethod.GET)
	public Plant searchByName(@RequestParam String name) {
		Plant searchByNameResult = thePlants.searchPlantByPlantName(name);
		return searchByNameResult;
	}
	
	@RequestMapping(path = {"/plantCostByPlot"}, method = RequestMethod.GET)
		public LineItem getPlantCostFromPlot(Plot plot) {
			LineItem plantCostPlot = thePlants.getPlantCostFromPlot(plot);
			return plantCostPlot;
		}
	@RequestMapping(path = {"/removePlantFromSystem/{id}"}, method = RequestMethod.DELETE)
		public void removePlantFromSystem(@PathVariable int id) {
		thePlants.removePlant(id);
	}
	
	


}
