package com.techelevator.model;

public class Garden {
	private Long userId;
	private int gardenId;
	private double gardenLength;
	private double gardenWidth;
	
	public Garden() {
		
	}
	public Garden(Long userId, int gardenId, double gardenLength, double gardenWidth) {
		super();
		this.userId = userId;
		this.gardenId = gardenId;
		this.gardenLength = gardenLength;
		this.gardenWidth = gardenWidth;
		
	}
	public Garden(int gardenId, double gardenLength, double gardenWidth) {
		super();
		this.gardenId = gardenId;
		this.gardenLength = gardenLength;
		this.gardenWidth = gardenWidth;
	}
	public Garden(double gardenLength, double gardenWidth) {
		super();
		this.gardenLength = gardenLength;
		this.gardenWidth = gardenWidth;
		
	}
	
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getGardenId() {
		return gardenId;
	}
	public void setGardenId(int gardenId) {
		this.gardenId = gardenId;
	}
	public double getGardenLength() {
		return gardenLength;
	}
	public void setGardenLength(double gardenLength) {
		this.gardenLength = gardenLength;
	}
	public double getGardenWidth() {
		return gardenWidth;
	}
	public void setGardenWidth(double gardenWidth) {
		this.gardenWidth = gardenWidth;
	}
	public String getGardenName() {
		return gardenName;
	}
	public void setGardenName(String gardenName) {
		this.gardenName = gardenName;
	}
	private String gardenName;

}
