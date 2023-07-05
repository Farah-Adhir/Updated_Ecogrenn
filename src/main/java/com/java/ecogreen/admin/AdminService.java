package com.java.ecogreen.admin;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;




@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	public Iterable<Admin> getAllAdmin() {
		return adminRepository.findAll();
	}

	public Admin getAdminById(int id)   
	{  
	return adminRepository.findById(id).get();  
	}  
	
	public void saveOrUpdate(Admin admin)   
	{  
		adminRepository.save(admin);  
	}    
	
	public void delete(int id)   
	{  
		adminRepository.deleteById(id);  
	} 
	
	public void update(Admin admin, int adminid)   
	{  
		adminRepository.save(admin);  
	}



}
