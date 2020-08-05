package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Garden;

@Component
public class GardenSqlDAO implements GardenDAO {
	
	private JdbcTemplate template;
	
	
	public GardenSqlDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	
	@Override
	public List<Garden> getAllGardens(){
		String sql = "SELECT * FROM garden";
		SqlRowSet results = template.queryForRowSet(sql);
		List<Garden> retrievedGardens = new ArrayList<>();
		while (results.next()) {
			retrievedGardens.add(mapRowToGarden(results));
		}
		return retrievedGardens;
	}
	@Override
	public Garden searchGardenByName() {
		Garden garden = null;
		String sql = "SELECT * FROM garden WHERE garden_name = ?";
		SqlRowSet results = template.queryForRowSet(sql);
		if(results.next()) {
			garden = mapRowToGarden(results);
		}
		return garden;
	}
	
	
	
	private Garden mapRowToGarden(SqlRowSet results) {
		Garden garden = new Garden();
		garden.setUserId(results.getLong("user_id"));
		garden.setGardenId(results.getInt("garden_id"));
		garden.setGardenLength(results.getDouble("length"));
		garden.setGardenWidth(results.getDouble("width"));
		garden.setGardenName(results.getString("garden_name"));
		return garden;
		
	}

	

}
