package com.cg.obs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.obs.dto.User;
import com.cg.obs.service.LoginService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class Controller {
	
	@Autowired
	LoginService loginService;
	  
	
	Logger log=LoggerFactory.getLogger(Controller.class);
	
	@HystrixCommand(fallbackMethod="HomeFail",commandKey="Home",groupKey="Home")
	@GetMapping("/")
	public String Home()
	{
		return  "Home Page For RequestStatus MicroService";
		
	}
	public String HomeFail()
	{
		return "Error loading Home Page";
	}
	
	@HystrixCommand(fallbackMethod="customerLoginFail")
	@PostMapping("/customer-login")
	public boolean customerLogin(@RequestBody User user)
	{
		return loginService.userLogin(user);
	}
	
	public boolean customerLoginFail(@RequestBody User user)
	{
	return false;
	}
	
	
	@HystrixCommand(fallbackMethod="adminLoginFail")
	@PostMapping("/admin-login")
	public boolean adminLogin(@RequestBody User user)
	{
		return loginService.adminLogin(user);
	}
	public boolean adminLoginFail(@RequestBody User user)
	{
		return false;
	}
	
	
	@HystrixCommand(fallbackMethod="newUserFail")
	@PostMapping("/newUser")
	public User newUser(@RequestBody User user)
	{
		return loginService.newUser(user);
	}
	public User newUserFail(@RequestBody User user)
	{
		return null;
	} 
	
	
	
	
	
	


}
