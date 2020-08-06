package com.techelevator.model;

public class ShoppingList {
	private int gardenId;
	private int supplyId;
	private int supplyQty;
	
	
	
	
	
	
	
	public ShoppingList() {
		super();
	}
	public ShoppingList(int supplyId, int supplyQty) {
		super();
		this.supplyId = supplyId;
		this.supplyQty = supplyQty;
	}
	public ShoppingList(int gardenId, int supplyId, int supplyQty) {
		super();
		this.gardenId = gardenId;
		this.supplyId = supplyId;
		this.supplyQty = supplyQty;
	}
	public int getGardenId() {
		return gardenId;
	}
	public void setGardenId(int gardenId) {
		this.gardenId = gardenId;
	}
	public int getSupplyId() {
		return supplyId;
	}
	public void setSupplyId(int supplyId) {
		this.supplyId = supplyId;
	}
	public int getSupplyQty() {
		return supplyQty;
	}
	public void setSupplyQty(int supplyQty) {
		this.supplyQty = supplyQty;
	}
	
	

}
