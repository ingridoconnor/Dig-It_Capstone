package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.LineItem;
import com.techelevator.model.ShoppingList;
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
	public Supplies searchSupplyBySupplyName(String name) {
		Supplies supply = null;
		String sql = "SELECT * FROM supplies WHERE supply_name = ?";
		SqlRowSet results = template.queryForRowSet(sql, name);
		if(results.next()) {
			supply = mapRowToSupply(results);
		}
		return supply;
	}
	@Override
	public LineItem getSuppliesFromSupplyCount() {
		LineItem supply = null;
		String sql = "SELECT SUM(supply_cost * garden_supplies.supply_qty) AS line_cost "
				+ "FROM supplies "
				+ "INNER JOIN garden_supplies"
				+ "ON supplies.supply_cost = garden_supplies.supply_qty"
				+ "WHERE garden_supplies.supply_id = ?";
			SqlRowSet results = template.queryForRowSet(sql);
			if(results.next()) {
				supply.setCost(results.getBigDecimal("line_cost"));
				supply.setItemName(results.getString("supply_name"));
			}
		return supply;
	}
	
	@Override
	public void addToShoppingListGardenSupplies(ShoppingList item) {
		String sql = "INSERT INTO garden_supplies VALUES (?, ?, ?)";
		template.update(sql, item.getGardenId(), item.getSupplyId(), item.getSupplyQty());
		
	}
	
	private Supplies mapRowToSupply(SqlRowSet results) {
		Supplies supply = new Supplies();
		supply.setSupplyCost(results.getBigDecimal("supply_cost"));
		supply.setSupplyId(results.getInt("supply_id"));
		supply.setSupplyName(results.getString("supply_name"));
		return supply;
	}

	

	

}
