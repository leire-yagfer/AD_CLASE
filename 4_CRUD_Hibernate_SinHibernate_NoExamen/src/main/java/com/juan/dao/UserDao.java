package com.juan.dao;

import java.util.List;

import com.juan.model.User;

public interface UserDao {
	
	void saveUser(User user);

	User getUserById(int id);

	List<User> getAllUsers();

	void updateUser(User user);

	void deleteUserById(int id);

}
