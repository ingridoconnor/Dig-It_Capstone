package com.techelevator.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.HZone;
import com.techelevator.model.User;

@Component
public class HZoneSqlDAO implements HZoneDAO {
	
	private JdbcTemplate template;

	public HZoneSqlDAO(DataSource datasource) {
	    template = new JdbcTemplate(datasource);
	}

	@Override
	public void getHZoneByZip(User user, String hzone) {
		String sql = "update user_data SET region = ? where user_id = ?";
		template.update(sql, hzone, user.getId());
	}
	
	@Override
	public HZone getHZoneDetails(User user) {
		HZone details = null;
		String sql = "SELECT h.zone_name, h.avg_last_frost_month, h.avg_last_frost_day, h.avg_first_frost_month, h.avg_first_frost_day, h.avg_growing_days FROM hardiness " + 
				"	JOIN user_data u ON u.region=h.zone_name " + 
				"	WHERE u.zip = ? " + 
				"	GROUP BY h.zone_name";
		SqlRowSet results = template.queryForRowSet(sql, user);
		if(results.next()) {
			details = mapRowToZone(results);
		}
		return details;
	}
	
	
	private HZone mapRowToZone(SqlRowSet results) {
		HZone hzone = new HZone();
		hzone.setZone(results.getString("zone_name"));
		hzone.setAvgLastFrostMonth(results.getString("avg_last_frost_month"));
		hzone.setAvgLastFrostDay(results.getInt("avg_last_frost_day"));
		hzone.setAvgFirstFrostMonth(results.getString("avg_first_frost_month"));
		hzone.setAvgFirstFrostDay(results.getInt("avg_first_frost_day"));
		hzone.setAvgGrowingDays(results.getInt("avg_growing_days"));
		return hzone;
	}
	

	
	
}
