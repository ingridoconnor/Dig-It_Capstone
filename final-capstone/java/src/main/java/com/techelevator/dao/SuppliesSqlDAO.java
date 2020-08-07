package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Supplies;
@Component
public class SuppliesSqlDAO implements SuppliesDAO{
	
	private JdbcTemplate template;
	
	public SuppliesSqlDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
		
	}

	@Override
	public List<Supplies> getAllSupplies() {
		String sql = "SELECT * FROM supplies";
		SqlRowSet results = template.queryForRowSet(sql);
		List<Supplies> retrievedSupplies = new ArrayList<>();
		while(results.next()) {
			retrievedSupplies.add(mapRowToSupply(results));
		}
		return retrievedSupplies;
	}

	@Override
	public Supplies searchSupplyBySupplyName() {
		Supplies supply = null;
		String sql = "SELECT * FROM supplies WHERE supply_name = ?";
		SqlRowSet results = template.queryForRowSet(sql);
		if(results.next()) {
			supply = mapRowToSupply(results);
		}
		return supply;
	}
	@Override
	public Supplies getSuppliesFromSupplyCount() {
		Supplies supply = null;
		String sql = "SELECT SUM(supply_cost * garden_supplies.supply_qty) "
				+ "FROM supplies "
				+ "INNER JOIN garden_supplies"
				+ "ON supplies.supply_cost = garden_supplies.supply_qty"
				+ "WHERE garden_supplies.supply_id = ?";
			SqlRowSet results = template.queryForRowSet(sql);
			if(results.next()) {
				supply = mapRowToSupply(results);
			}
		return supply;
	}
	
	private Supplies mapRowToSupply(SqlRowSet results) {
		Supplies supply = new Supplies();
		supply.setSupplyCost(results.getBigDecimal("supply_cost"));
		supply.setSupplyId(results.getInt("supply_id"));
		supply.setSupplyName(results.getString("supply_name"));
		return supply;
	}

	

}
