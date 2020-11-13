package com.cg.cbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cbs.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	IUserService service;
	
	
	@PutMapping("/add")
	public User add(@RequestBody User user)
	{
		return service.addUser(user);
	}
	
	@PostMapping("/update")
	public User update(@RequestBody User user)
	{
		
		if(service.findUser(user.getAadhar())!=null)
		{
			return service.editUser(user);
		}
		return null;
	}
	
	@GetMapping("/getAll")
	public List<User> getAll()
	{
		return service.getAllUsers();
	}
}