package com.andi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.andi.model.Product;
import com.andi.model.user;
@EnableJpaRepositories
@Repository

public interface ProductRepository extends JpaRepository<user, Integer>{
	Optional<user> findByEmailAndPassword(String email,String password);
	 user findByEmail(String email);
	
}
