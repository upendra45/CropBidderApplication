package com.cg.cbs.service;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

public interface IUserService {
	User login(User user);

	User logout(User user);

	User addUser(User user);

	User editUser(User user);

	List<User> getAllUsers();

}
