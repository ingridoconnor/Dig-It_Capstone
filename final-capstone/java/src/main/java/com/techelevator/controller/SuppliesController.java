package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.SuppliesDAO;
import com.techelevator.model.Supplies;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class SuppliesController {
	
	@Autowired
	SuppliesDAO theSupplies;
	
	@RequestMapping(path = { "/allSupplies/"}, method = RequestMethod.GET)
	public Supplies[] getAllSupplies() {
		List<Supplies> allSupplies = theSupplies.getAllSupplies();
		Supplies[] supplies = new Supplies[allSupplies.size()];
		supplies = allSupplies.toArray(supplies);
		return supplies;
	}
	
	@RequestMapping(path = { "/supplyNameSearch/"}, method = RequestMethod.GET)
	public Supplies searchSupplyBySupplyName() {
		Supplies searchSupplyBySupplyNameResult = theSupplies.searchSupplyBySupplyName();
		return searchSupplyBySupplyNameResult;
	}

}
