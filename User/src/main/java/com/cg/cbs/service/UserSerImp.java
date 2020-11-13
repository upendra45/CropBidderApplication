package com.cg.cbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;


import com.cg.cbs.exception.UserNotFoundException;
import com.cg.cbs.repository.IUserRepository;
@Service
public class UserSerImp implements IUserService
{
	@Autowired
	IUserRepository userRepo;
	
	public User findUser(String aadhar)
	{
		return userRepo.findById(Integer.parseInt(aadhar)).get();
	}
	public User addUser(User user)
	{
		return userRepo.save(user);
	}
	public User editUser(User user)
	{
		return userRepo.save(user);
	}
	public List<User> getAllUsers() 
	{
		return userRepo.findAll();
	}
	
	public User login(User user)
	{
		User userObj=userRepo.findById( user.getUserId()).orElse(null);
		if(userObj!=null)
		{
			if(userObj.getPassword().equals(user.getPassword()))
			{
				return userObj;
			}
			else
			{
				throw new UserNotFoundException("Invalid username or password");
			}
		}
		else
		{
			throw new UserNotFoundException("Details does not exist...Please register");
		}
	}
	
	public User logout(User user)
	{
		return user;
	}
}