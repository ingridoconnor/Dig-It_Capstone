package com.techelevator.dao;

import com.techelevator.model.User;

public interface UserDataDAO {
	User createAccountUserData(User user);
	
	User getUserDataFromID(User user);

}
