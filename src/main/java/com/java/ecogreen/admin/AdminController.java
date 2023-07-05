package com.java.ecogreen.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

	@Autowired 
	private AdminService adminService;
	 
		@GetMapping
	Iterable<Admin> getAllAdmin() {
		return adminService.getAllAdmin();
	}
	
	@GetMapping("{id}")
	public Admin getAdmin(@PathVariable("id") int adminid)       
	{  
	return adminService.getAdminById(adminid);  
	} 
	
	@PostMapping 
	public int saveAdmin(@RequestBody Admin admin)   
	{  
		adminService.saveOrUpdate(admin);  
	return admin.getId();  
	}  
	
	@DeleteMapping("{id}")  
	public void deleteAdmin(@PathVariable("id") int adminid)   
	{  
		adminService.delete(adminid);  
	}  
	
	@PutMapping("{id}")
	public Admin update(@RequestBody Admin admin)   
	{  
		adminService.saveOrUpdate(admin);  
	return admin;  
	}  

}
