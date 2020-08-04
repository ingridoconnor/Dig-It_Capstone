package com.techelevator.model;

public class Plot {
	private Long plotId;
	private int gardenId;
	private double plotLength;
	private double plotWidth;
	private String plotName;
	
	
	
	public Plot() {
		
	}
	public Plot(Long plotId, int gardenId, double plotLength, double plotWidth, String plotName) {
		super();
		this.plotId = plotId;
		this.gardenId = gardenId;
		this.plotLength = plotLength;
		this.plotWidth = plotWidth;
		this.plotName = plotName;
		
	}
	public Plot(int gardenId, double plotLength, double plotWidth, String plotName) {
		super();
		this.gardenId = gardenId;
		this.plotLength = plotLength;
		this.plotWidth = plotWidth;
		this.plotName = plotName;
	}
	public Plot(double plotLength, double plotWidth, String plotName) {
		super();
		this.plotLength = plotLength;
		this.plotWidth = plotWidth;
		this.plotName = plotName;
		
	}
	
	
	
	
	public Long getPlotId() {
		return plotId;
	}
	public void setPlotId(Long plotId) {
		this.plotId = plotId;
	}
	public int getGardenId() {
		return gardenId;
	}
	public void setGardenId(int gardenId) {
		this.gardenId = gardenId;
	}
	public double getPlotLength() {
		return plotLength;
	}
	public void setPlotLength(double plotLength) {
		this.plotLength = plotLength;
	}
	public double getPlotWidth() {
		return plotWidth;
	}
	public void setPlotWidth(double plotWidth) {
		this.plotWidth = plotWidth;
	}
	public String getPlotName() {
		return plotName;
	}
	public void setPlotName(String plotName) {
		this.plotName = plotName;
	}
	
	
	
	
	
	
	
	
	

}
