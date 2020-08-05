package com.techelevator.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.techelevator.model.User;

@Component
public class UserDataSqlDAO {
	private JdbcTemplate template;
	
	public UserDataSqlDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	
//	@Override
//	public User createAccountUserData(User user) {
//		String sql = "INSERT INTO user_data (user_id, first_name, last_name, email, region, city, state, zip) "
//				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//		Long newUserId = template.queryForObject(sql, Long.class, user.getFirstName(), user.getLastName(), user.getEmail(), 
//				user.getRegion(), user.getCity(), user.getState(), user.getZipcode())
//	}
//	
//	
}
