package com.java.ecogreen.user;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.ecogreen.admin.Admin;


@Service
public class UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	//User findCustomerByEmail(String email);
	
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUsersById(int id)   
	{  
	return userRepository.findById(id).get();  
	}  
	
	public void saveOrUpdate(User user)   
	{  
		userRepository.save(user);  
	}  
	
	public void delete(int id)   
	{  
		userRepository.deleteById(id);  
	} 
	
	public void update(User user, int userid)   
	{  
		userRepository.save(user);  
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

	public void save(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	
	



	
		
	
}
