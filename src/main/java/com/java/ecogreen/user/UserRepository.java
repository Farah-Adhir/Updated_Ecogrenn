package com.java.ecogreen.user;

import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;





public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findOneByEmailAndPassword(String email, String password);
	User findByEmail(String email);
	static User save(org.springframework.boot.autoconfigure.security.SecurityProperties.User user) {
      
		return null;
	}

}
