package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.PlantDAO;
import com.techelevator.dao.SuppliesDAO;
import com.techelevator.model.LineItem;
import com.techelevator.model.Plant;
import com.techelevator.model.Plot;
import com.techelevator.model.ShoppingList;
import com.techelevator.model.Supplies;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ShoppingListController {
	@Autowired
	SuppliesDAO theSupplies;
	@Autowired
	PlantDAO thePlants;
	
//	@RequestMapping(path = { "/myShoppingList"}, method = RequestMethod.GET)
//	public ShoppingList[] listAllItems() {
//		List<ShoppingList> allItems = null;
//		List<Supplies> allSupplies = theSupplies.getAllSupplies();
//		List<Plant> allPlants = thePlants.getAllPlants();
//	
//		Plant[] plants = new Plant[allPlants.size()];
//		plants = allPlants.toArray(plants);
//		return plants;
//		
//		Supplies[] supply = new Supplies[allSupplies.size()];
//		supply = allSupplies.toArray(supply);
//		return supply;
//		
//	}
	@RequestMapping(path = { "/addToMyShoppingList"}, method = RequestMethod.POST)
	public void addToList(@RequestParam String listItem, @RequestParam long gardenId, @RequestParam int quantity) {
		
		Plant plant = thePlants.searchPlantByPlantName(listItem);
		
		Supplies supply = theSupplies.searchSupplyBySupplyName(listItem);
		if(plant != null) {
			ShoppingList item = new ShoppingList();
			item.setGardenId(gardenId);
			item.setSupplyId(plant.getId());
			item.setSupplyQty(quantity);
			theSupplies.addToShoppingListGardenSupplies(item);
		}
		if(supply != null) {
			ShoppingList item = new ShoppingList();
			item.setGardenId(gardenId);
			item.setSupplyId(supply.getSupplyId());
			item.setSupplyQty(quantity);
			theSupplies.addToShoppingListGardenSupplies(item);
		}
		
	}
	@RequestMapping(path = {"/generateSuggestedSeedlingList"}, method = RequestMethod.GET)
	public LineItem[] suggestedList(@RequestBody Plot[] plots) {
		List<LineItem> items = new ArrayList<>();
		for(Plot p: plots) {
			items.add(thePlants.getPlantCostFromPlot(p));
		}
		LineItem[] seedling = new LineItem[items.size()];
		for(int i = 0; i > items.size(); i++) {
			seedling[i] = items.get(i);
		}
				
		return seedling;
		
		
		
		
	}
	

}
