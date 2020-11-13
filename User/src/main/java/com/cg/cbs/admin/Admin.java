package com.cg.cbs.admin;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.cbs.beans.User;
import com.cg.cbs.service.UserService;

public class Admin 
{
	@Autowired
	UserService service;
	
	public String validateUser(User user)
	{
		if(service.findUser(user.getAadhar())==null)
		{
			String userName="[a-zA-Z0-9@#$*&]{6,10}";
			String password="[A-Z]{1}[a-z0-9]{5,}";
			String mobileNo="[6789][0-9]{9}";
			if(user.getUserId().matches(userName) && user.getPassword().matches(password) && user.getMobile().matches(mobileNo))
			{
				service.addUser(user);
				return "Registration Successful...";
			}
			else
				return "Enter the details matching with specifications" ;
		}
		else
		{
			throw new RuntimeException("Enter the details matching with specifications");
		}
	}
	
}