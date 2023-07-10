package com.java.ecogreen.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.ecogreen.admin.Admin;
import com.java.ecogreen.user.User;
import com.java.ecogreen.user.UserService;



@Controller

public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	com.java.ecogreen.user.UserRepository userRepo;
    
    @ModelAttribute("user")
    public UserLoginDTO userLoginDTO() {
        return new UserLoginDTO();
    }
 
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/index")
	public String home() {
		return "index";
	}
	
	 @GetMapping("/admin")
		public String admin() {
			return "admin";
		}
	 
	
	
	
	@PostMapping
	public void loginUser(@ModelAttribute("user") 
	UserLoginDTO userLoginDTO) {
		System.out.println("UserDTO"+userLoginDTO);
		 loginService.loadUserByUsername(userLoginDTO.getUsername());
	}
}
