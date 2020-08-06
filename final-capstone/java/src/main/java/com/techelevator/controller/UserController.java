package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.UserDAO;
import com.techelevator.dao.UserDataDAO;
import com.techelevator.model.User;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserDataDAO udDao;
	
	@Autowired
	UserDAO uDao;
	
	@RequestMapping(path = { "/user/{id}"}, method = RequestMethod.GET)
	public User getUserData(@PathVariable long id) {
		User user = new User();
		user.setId(id);
		User newUser = new User();
		newUser = udDao.getUserDataFromID(user);
		return newUser;
	}
	

	
	
	
	
	
	
	
}
