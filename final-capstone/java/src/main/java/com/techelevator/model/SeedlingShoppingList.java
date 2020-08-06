package com.techelevator.model;

import java.math.BigDecimal;

public class SeedlingShoppingList {
	private Plant[] seeds;
	private BigDecimal seedCost;
	private String seedlingName;
	private int seedQuantity;
	
	
	
	
	
	
	
	
	
	
	
	
	public SeedlingShoppingList() {
		super();
	}
	public SeedlingShoppingList(Plant[] seeds, BigDecimal seedCost, String seedlingName, int seedQuantity) {
		super();
		this.seeds = seeds;
		this.seedCost = seedCost;
		this.seedlingName = seedlingName;
		this.seedQuantity = seedQuantity;
	}
	public Plant[] getSeeds() {
		return seeds;
	}
	public void setSeeds(Plant[] seeds) {
		this.seeds = seeds;
	}
	public BigDecimal getSeedCost() {
		return seedCost;
	}
	public void setSeedCost(BigDecimal seedCost) {
		this.seedCost = seedCost;
	}
	public String getSeedlingName() {
		return seedlingName;
	}
	public void setSeedlingName(String seedlingName) {
		this.seedlingName = seedlingName;
	}
	public int getSeedQuantity() {
		return seedQuantity;
	}
	public void setSeedQuantity(int seedQuantity) {
		this.seedQuantity = seedQuantity;
	}
	

}
