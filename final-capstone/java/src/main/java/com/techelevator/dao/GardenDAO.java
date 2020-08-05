package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Garden;

public interface GardenDAO {
	List<Garden>getAllGardens();
	Garden searchGardenByName();
	Garden addNewGarden(Garden garden);

}
