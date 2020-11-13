package com.cg.cbs.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<User,Integer> {
	

	List<User> getAllUsers();
	
}

