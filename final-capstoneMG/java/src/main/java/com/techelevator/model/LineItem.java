package com.techelevator.model;

import java.math.BigDecimal;

public class LineItem {
	private BigDecimal cost;
	private String itemName;
	
	
	
	
	
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
