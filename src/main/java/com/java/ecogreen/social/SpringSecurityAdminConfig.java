//package com.java.ecogreen.social;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import com.java.ecogreen.admin.AdminService;
//import com.java.ecogreen.login.LoginService;
//import com.java.ecogreen.user.UserService;
//
//
//@Configuration
//@EnableWebSecurity
//@Order(2)
//public class SpringSecurityAdminConfig {
//	
//	@Autowired
//	private  AdminService adminService;
//	
//	@Autowired
//	AuthenticationSuccessHandler successHandler;
//
////	@Bean
////    public BCryptPasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//	
//	@Bean
//// DaoAuthenticationProvider authenticationProviderAdmin() {
////        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
////        auth.setUserDetailsService(adminService);
////        return auth;
////    }
//	
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//	
//
//	
//
//	@Bean
//	SecurityFilterChain filterChainAdmin(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(requests -> requests
//                        .antMatchers("/registration/**", "/login/**","/admin/**").permitAll()
//                        .anyRequest().authenticated())
//		        .formLogin(admin -> admin.loginPage("/admin").successHandler(successHandler))
//		        .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/admin"))
//        	  .oauth2Login(admin -> admin.loginPage("/admin").successHandler(successHandler));
//        
//               
//return http.build();
//
//    }
//
//}
