package com.java.ecogreen.social;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.java.ecogreen.admin.Admin;
import com.java.ecogreen.user.UserService;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

	@Autowired
	com.java.ecogreen.user.UserRepository userRepo;
	
	@Autowired
	UserService userService;
		
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		String redirectUrl = null;
		if(authentication.getPrincipal() instanceof DefaultOAuth2User) {
		DefaultOAuth2User  userDetails = (DefaultOAuth2User ) authentication.getPrincipal();
         String email = userDetails.getAttribute("email") !=null?userDetails.getAttribute("email"):userDetails.getAttribute("login")+"@gmail.com" ;
          if(userRepo.findByEmail(email) == null) {
        	  com.java.ecogreen.user.User user = new com.java.ecogreen.user.User();
        	  user.setEmail(redirectUrl);
        	  user.setName(userDetails.getAttribute("email") !=null?userDetails.getAttribute("email"):userDetails.getAttribute("login"));
        	  user.setPassword(("Dummy"));
        	 
        	  userService.save(user);
          }
          String username1 = userDetails.getAttribute("email") !=null?userDetails.getAttribute("email"):userDetails.getAttribute("admin")+"@gmail.com" ;
          if(userRepo.findByEmail(username1) == null) {
        	  Admin admin = new Admin();
        	  admin.setEmail(redirectUrl);
        	  admin.setName(userDetails.getAttribute("email") !=null?userDetails.getAttribute("email"):userDetails.getAttribute("admin"));
        	  admin.setPassword(("Dummy"));
        	 
        	  userService.save(admin);
          }
		}  redirectUrl = "/index";
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}

}
