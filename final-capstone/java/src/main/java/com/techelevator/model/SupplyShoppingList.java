package com.techelevator.model;

import java.math.BigDecimal;

public class SupplyShoppingList {
	private Supplies[] supplies;
	private BigDecimal supplyCost;
	private String supplyName;
	private int supplyQuantity;
	
	
	
	
	
	
	public SupplyShoppingList() {
		super();
	}
	public SupplyShoppingList(Supplies[] supplies, BigDecimal supplyCost, String supplyName, int supplyQuantity) {
		super();
		this.supplies = supplies;
		this.supplyCost = supplyCost;
		this.supplyName = supplyName;
		this.supplyQuantity = supplyQuantity;
	}
	public Supplies[] getSupplies() {
		return supplies;
	}
	public void setSupplies(Supplies[] supplies) {
		this.supplies = supplies;
	}
	public BigDecimal getSupplyCost() {
		return supplyCost;
	}
	public void setSupplyCost(BigDecimal supplyCost) {
		this.supplyCost = supplyCost;
	}
	public String getSupplyName() {
		return supplyName;
	}
	public void setSupplyName(String supplyName) {
		this.supplyName = supplyName;
	}
	public int getSupplyQuantity() {
		return supplyQuantity;
	}
	public void setSupplyQuantity(int supplyQuantity) {
		this.supplyQuantity = supplyQuantity;
	}

}
