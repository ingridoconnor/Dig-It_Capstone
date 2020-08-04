package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Plant;

public interface PlantDAO {
	
	List<Plant> getAllPlants();
	Plant searchPlantByPlantName();
	Plant addNewPlant(Plant plant);
	
}
