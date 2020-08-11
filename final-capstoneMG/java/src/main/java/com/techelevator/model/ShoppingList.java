package com.techelevator.model;

public class ShoppingList {
	private long gardenId;
	private long supplyId;
	private int supplyQty;
	
	
	
	
	
	
	
	public ShoppingList() {
		super();
	}
	public ShoppingList(long supplyId, int supplyQty) {
		super();
		this.supplyId = supplyId;
		this.supplyQty = supplyQty;
	}
	public ShoppingList(long gardenId, long supplyId, int supplyQty) {
		super();
		this.gardenId = gardenId;
		this.supplyId = supplyId;
		this.supplyQty = supplyQty;
	}
	public long getGardenId() {
		return gardenId;
	}
	public void setGardenId(long gardenId) {
		this.gardenId = gardenId;
	}
	public long getSupplyId() {
		return supplyId;
	}
	public void setSupplyId(long supplyId) {
		this.supplyId = supplyId;
	}
	public int getSupplyQty() {
		return supplyQty;
	}
	public void setSupplyQty(int supplyQty) {
		this.supplyQty = supplyQty;
	}
	
	

}
