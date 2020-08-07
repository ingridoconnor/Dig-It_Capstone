package com.techelevator.model;

public class Plot {
	private Long plotId;
	private int gardenId;
	private double plotLength;
	private double plotWidth;
	private int plantId;
	
	
	
	public Plot() {
		
	}
	
	public Plot(Long plotId, int gardenId, double plotLength, double plotWidth, int plantId) {
		super();
		this.plotId = plotId;
		this.gardenId = gardenId;
		this.plotLength = plotLength;
		this.plotWidth = plotWidth;
		this.plantId = plantId;
	}
	
	
	
	
	public Plot(int gardenId, double plotLength, double plotWidth, int plantId) {
		super();
		this.gardenId = gardenId;
		this.plotLength = plotLength;
		this.plotWidth = plotWidth;
		this.plantId = plantId;
	}

	
	public Plot(double plotLength, double plotWidth, int plantId) {
		super();
		this.plotLength = plotLength;
		this.plotWidth = plotWidth;
		this.plantId = plantId;
	}
	

	public Plot(double plotLength, double plotWidth) {
		super();
		this.plotLength = plotLength;
		this.plotWidth = plotWidth;
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





	public int getPlantId() {
		return plantId;
	}





	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}





	
	
	
	
	
	
	
	
	

}
