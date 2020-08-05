package com.techelevator.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.User;

@Component
public class UserDataSqlDAO implements UserDataDAO{
	private JdbcTemplate template;
	
	public UserDataSqlDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	
	@Override
	public User createAccountUserData(User user) {
		System.out.println("creating user account");
		String sql = "INSERT INTO user_data (user_id, first_name, last_name, email, city, state, zip) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		template.update(sql, user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getCity(), user.getState(), user.getZipcode());
		
		
		return user;
	}
	
	
	
	
	

	
	
}
