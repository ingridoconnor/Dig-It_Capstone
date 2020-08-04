package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Plant;


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
	    return mapResultsToPlants(results);    
	}
	
	

	private List<Plant> mapResultsToPlants(SqlRowSet results) {
	    List<Plant> retrievedPlants = new ArrayList<>();
	    while (results.next()) {
	        retrievedPlants.add(mapRowToPlant(results));
	    }

	    return retrievedPlants;
	}

	@Override
	public Plant searchPlantByPlantName() {
		Plant plant = null;
		String sql = "SELECT * FROM plant WHERE plant_name = ?";
		SqlRowSet results = template.queryForRowSet(sql);
		if(results.next()) {
			plant = mapRowToPlant(results);
		}
		
		return plant;
	}
	@Override
	public Plant addNewPlant(Plant plant) {
		String sql = "INSERT INTO plant (plant_name, description, plants_per_sq_foot, sun_requirements, region, seed_cost) VALUES (?, ?, ?, ?, ?, ?) RETURING plant_id";
		int newPlantId = template.queryForObject(sql, int.class, plant.getName(), plant.getDescription(), plant.getPlantsPerSqFoot(), plant.getSunRequirements(), plant.getRegion(), plant.getSeedCost());
		plant.setId(newPlantId);
		return plant;
	}
	private Plant mapRowToPlant(SqlRowSet results) {
		Plant plant = new Plant();
		plant.setId(results.getInt("plant_id"));
		plant.setDescription(results.getString("description"));
		plant.setName(results.getString("plant_name"));
		plant.setPlantsPerSqFoot(results.getInt("plants_per_sq_foot"));
		plant.setRegion(results.getString("region"));
		plant.setSeedCost(results.getBigDecimal("seed_cost"));
		return plant;
	}


}
