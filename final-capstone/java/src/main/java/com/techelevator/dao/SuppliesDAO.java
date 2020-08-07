package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Supplies;

public interface SuppliesDAO {
	
	List<Supplies> getAllSupplies();
	Supplies searchSupplyBySupplyName();
	Supplies getSuppliesFromSupplyCount();
	

}
