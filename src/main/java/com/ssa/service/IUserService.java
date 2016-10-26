package com.ssa.service;

import java.util.List;

import com.ssa.entity.User;

public interface IUserService {
	
	List<User> getAllUsers();
	User getUserById(int userId);
	User getUserByUsername(String username);
}
