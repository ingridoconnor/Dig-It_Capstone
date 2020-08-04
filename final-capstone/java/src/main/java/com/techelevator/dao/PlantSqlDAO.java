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
	    String sqlPuppy = "SELECT * from plant";
	    SqlRowSet results = template.queryForRowSet(sqlPuppy);
	    return mapResultsToPlants(results);    
	}
	
	private Plant mapResultToPuppy(SqlRowSet result) {
	    Plant retrievedPuppy = new Plant(result.getInt("id"), result.getString("name"), result.getString("description"),
	            result.getInt("plantsPerSqFoot"), result.getString("sunRequirements"), result.getString("region"), result.getBigDecimal("seedCost"));

	    return retrievedPuppy;
	}

	private List<Plant> mapResultsToPlants(SqlRowSet results) {
	    List<Plant> retrievedPuppies = new ArrayList<>();
	    while (results.next()) {
	        retrievedPuppies.add(mapResultToPuppy(results));
	    }

	    return retrievedPuppies;
	}

}
