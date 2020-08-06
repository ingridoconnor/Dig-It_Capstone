package com.techelevator.model;

import java.util.Map;

public class HZone {

	private String zone;
	private Map<String, Double> lat;
	private String temperatureRange;
	
	
	public HZone() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
	
	public Map<String, Double> getLat() {
		return lat;
	}

	public void setLat(Map<String, Double> lat) {
		this.lat = lat;
	}

	public String getTemperatureRange() {
		return temperatureRange;
	}

	public void setTemperatureRange(String temperatureRange) {
		this.temperatureRange = temperatureRange;
	}

}
