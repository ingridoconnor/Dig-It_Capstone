package com.techelevator.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Plot;
import com.techelevator.model.ShoppingList;

public class ShoppingListSqlDAO implements ShoppingListDAO {
	
	private JdbcTemplate jdbcTemplate;
	public ShoppingListSqlDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
//	@Override
//	public ShoppingList getPlantCostFromPlot(Plot plot) {
//		ShoppingList list = null;
//		String sql = "SELECT seedling_cost, plant_name, plant_per_sq_foot FROM plant "
//				+ "WHERE plant_id = ?";
//		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, plot);
//		if(results.next()) {
//			list = 
//		}
//		return null;
//	}

	@Override
	public ShoppingList getSuppliesFromPlotCount(int plotCount) {
		// TODO Auto-generated method stub
		return null;
	}

}
