package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.UserDataDAO;
import com.techelevator.model.User;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserDataController {
	
	@Autowired
	UserDataDAO theUserData;
	
	@RequestMapping(path = { "/editProfile"}, method = RequestMethod.PUT)
	public User editProfile(User user) {
		User editedProf = theUserData.editProfile(user);
		return editedProf;
		
	}
	

}
