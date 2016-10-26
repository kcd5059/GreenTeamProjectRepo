package com.ssa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssa.entity.Team;
import com.ssa.entity.User;

@Transactional
@Repository
public class UserDAO implements IUserDAO {
	
	@Autowired
    private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String hql = "FROM User ORDER BY id";
		return (List<User>) hibernateTemplate.find(hql);
	}

	@Override
	public User getUserById(int userId) {
		return (User) hibernateTemplate.get(User.class, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByUsername(String username) {
		System.out.println(username);
		String hql = "FROM User where username = " + "'" +  username + "'";
		List<User> results = (List<User>) hibernateTemplate.find(hql);
		System.out.println(hql);
		return results.get(0);
	}

}
