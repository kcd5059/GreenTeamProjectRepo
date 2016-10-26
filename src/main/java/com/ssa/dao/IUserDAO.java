package com.ssa.dao;

import java.util.List;
import com.ssa.entity.User;

public interface IUserDAO {

	List<User> getAllUsers();
	User getUserById(int userId);
	User getUserByUsername(String username);
}
