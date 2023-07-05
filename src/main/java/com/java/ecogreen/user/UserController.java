package com.java.ecogreen.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired 
	private UserService userService;
	 
	
	@GetMapping
	Iterable<User> getAllUser() {
		return userService.getAllUsers();
	}
	
	@GetMapping("{id}")
	public User getUser(@PathVariable("id") int userid)       
	{  
	return userService.getUsersById(userid);  
	} 
	
	@PostMapping 
	public int saveUser(@RequestBody User user)   
	{  
		userService.saveOrUpdate(user);  
	return user.getId();  
	}  
	
	@DeleteMapping("{id}")  
	public void deleteUser(@PathVariable("id") int userid)   
	{  
		userService.delete(userid);  
	}  
	
	@PutMapping("{id}")
	public User update(@RequestBody User user)   
	{  
		userService.saveOrUpdate(user);  
	return user;  
	}  
}
