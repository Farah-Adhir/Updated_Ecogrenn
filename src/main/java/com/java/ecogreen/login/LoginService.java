package com.java.ecogreen.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.ecogreen.admin.Admin;
import com.java.ecogreen.admin.AdminRepository;
import com.java.ecogreen.user.User;
import com.java.ecogreen.user.UserRepository;

@Service
public class LoginService implements UserDetailsService {
	@Autowired
	public UserRepository userRepository;
	public AdminRepository adminRepository;

	com.java.ecogreen.user.User save(org.springframework.boot.autoconfigure.security.SecurityProperties.User user) {
		return null;
	}

	public User save(User user) {

		return userRepository.save(user);
	}

	public Admin save(Admin admin) {

		return adminRepository.save(admin);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(email);
		if (user == null) {

			throw new UsernameNotFoundException("Invalid username or password.");
		}
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
		List<SimpleGrantedAuthority> updatedAuthorities = new ArrayList<SimpleGrantedAuthority>();
		updatedAuthorities.add(authority);
		return new org.springframework.security.core.userdetails.User(user.getEmail(), "{noop}" + user.getPassword(),
				updatedAuthorities);

	}

}
