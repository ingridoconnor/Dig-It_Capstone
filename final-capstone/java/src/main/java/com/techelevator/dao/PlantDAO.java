package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Plant;
import com.techelevator.model.Plot;

public interface PlantDAO {
	
	List<Plant> getAllPlants();
	Plant searchPlantByPlantName();
	Plant addNewPlant(Plant plant);
	Plant getPlantCostFromPlot(Plot plot);
	
}
