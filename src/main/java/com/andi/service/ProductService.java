package com.andi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.andi.dto.userDto;
import com.andi.model.Product;

public interface ProductService {
	
	public Product saveProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public Product getProductById(Integer id);
	
	public String deleteProduct(Integer id);
	
	public Product editProduct(Product product,Integer id);
	
	
	ResponseEntity<String> register(userDto uDto);

	ResponseEntity<String> login(userDto uDto);
}

