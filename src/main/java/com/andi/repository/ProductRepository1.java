package com.andi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.andi.model.Product;
@EnableJpaRepositories
@Repository


public interface ProductRepository1 extends JpaRepository<Product, Integer> {

}
