package com.ssa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssa.entity.User;
import com.ssa.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllTeams() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable("uid") Integer uid) {
		User user = userService.getUserById(uid);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> getUserByUsername(@RequestBody User username) {
		User user = userService.getUserByUsername(username.getUsername());
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
