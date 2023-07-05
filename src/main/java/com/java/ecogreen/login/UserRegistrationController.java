package com.java.ecogreen.login;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.ecogreen.user.User;



@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private  LoginService loginService;

	

	public UserRegistrationController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}

	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") User user) {
		loginService.save(user);
		return "redirect:/registration?success";
	}
}
