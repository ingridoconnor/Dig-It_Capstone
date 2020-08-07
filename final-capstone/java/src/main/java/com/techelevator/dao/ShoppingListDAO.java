package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Plot;
import com.techelevator.model.ShoppingList;

public interface ShoppingListDAO {
	
//	ShoppingList getPlantCostFromPlot(Plot plot);
	ShoppingList getSuppliesFromPlotCount(int plotCount);

}
