package com.java.ecogreen.admin;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Integer> {

	Optional<Admin> findOneByEmailAndPassword(String email, String password);

	Admin findByEmail(String email);

}
