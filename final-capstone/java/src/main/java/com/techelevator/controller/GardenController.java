package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.GardenDAO;
import com.techelevator.model.Garden;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class GardenController {

	@Autowired
	GardenDAO theGarden;
	
	@RequestMapping(path = { "/allGardens/"}, method = RequestMethod.GET)
	public Garden[] getAllGardens() {
		List<Garden> allGardens = theGarden.getAllGardens();
		Garden[] gardens = new Garden[allGardens.size()];
		gardens = allGardens.toArray(gardens);
		return gardens;
	}
	
	@RequestMapping(path = { "/gardens"}, method = RequestMethod.POST)
	public Garden addGarden(@RequestBody Garden garden) {
		Garden gardenResult = theGarden.addNewGarden(garden);
		return gardenResult;
	}
	
	
	@RequestMapping(path = {"/gardenNameSearch/"}, method = RequestMethod.GET)
	public Garden searchGardenByName() {
		Garden searchGardenByNameResult = theGarden.searchGardenByName();
		return searchGardenByNameResult;
	}
	
	
	
	
	
	
	
	
}
