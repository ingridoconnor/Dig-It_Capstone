package com.techelevator.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
	
}
