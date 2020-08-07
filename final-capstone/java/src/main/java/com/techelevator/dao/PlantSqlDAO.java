package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.LineItem;
import com.techelevator.model.Plant;
import com.techelevator.model.Plot;
import com.techelevator.model.ShoppingList;


@Component
public class PlantSqlDAO implements PlantDAO {
	
	private JdbcTemplate template;

	public PlantSqlDAO(DataSource datasource) {
	    template = new JdbcTemplate(datasource);
	}

	@Override
	public List<Plant> getAllPlants() {
	    String sql = "SELECT * from plant";
	    SqlRowSet results = template.queryForRowSet(sql);
	    List<Plant> retrievedPlants = new ArrayList<>();
	    while (results.next()) {
	        retrievedPlants.add(mapRowToPlant(results));
	    }
	    return retrievedPlants;    
	}
	@Override
	public LineItem getPlantCostFromPlot(Plot plot) {
		LineItem list = null;
		String sql = "SELECT SUM(seedling_cost * plant_per_sq_foot) AS line_cost, plant_name FROM plant "
				+ "WHERE plant_id = ?";
		SqlRowSet results = template.queryForRowSet(sql, plot);
		if(results.next()) {
			list.setCost(results.getBigDecimal("line_cost"));
			list.setItemName(results.getString("plant_name"));
		}
		return list;
	}

	@Override
	public Plant searchPlantByPlantName(String name) {
		Plant plant = null;
		String sql = "SELECT * FROM plant WHERE plant_name = ?";
		SqlRowSet results = template.queryForRowSet(sql, name);
		if(results.next()) {
			plant = mapRowToPlant(results);
		}
		
		return plant;
	}
	@Override
	public Plant addNewPlant(Plant plant) {
		String sql = "INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seedling_cost) VALUES (?, ?, ?, ?, ?, ?) RETURNING plant_id";
		Long newPlantId = template.queryForObject(sql, Long.class, plant.getName(), plant.getDescription(), plant.getPlantsPerSqFoot(), plant.getSunRequirements(), plant.getRegion(), plant.getSeedlingCost());
		plant.setId(newPlantId);
		return plant;
	}
	private Plant mapRowToPlant(SqlRowSet results) {
		Plant plant = new Plant();
		plant.setId(results.getLong("plant_id"));
		plant.setDescription(results.getString("description"));
		plant.setName(results.getString("plant_name"));
		plant.setPlantsPerSqFoot(results.getInt("plants_per_sq_foot"));
		plant.setRegion(results.getString("region"));
		plant.setSeedlingCost(results.getBigDecimal("seedling_cost"));
		return plant;
	}


}
