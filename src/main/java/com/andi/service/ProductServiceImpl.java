package com.andi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.andi.dto.userDto;
import com.andi.model.Product;
import com.andi.model.user;
import com.andi.repository.ProductRepository;
import com.andi.repository.ProductRepository1;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private ProductRepository1 productRepo1;

	@Override
	public Product saveProduct(Product product) {
		
		return productRepo1.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
	
		return productRepo1.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		
		return productRepo1.findById(id).get();
		}

	@Override
	public String deleteProduct(Integer id) {
		Product product = productRepo1.findById(id).get();
		
		if(product !=null) {
			productRepo1.delete(product);
			return "Product Delete successfully";
		}
		
		return "Something wrong on server";
	}
	
	@Override
	public Product editProduct(Product p, Integer id) {
		Product oldproduct = productRepo1.findById(id).get();
	
		oldproduct.setProductName(p.getProductName());
		oldproduct.setDescription(p.getDescription());
		oldproduct.setPrice(p.getPrice());
		oldproduct.setStatus(p.getStatus());
		
		return productRepo1.save(oldproduct);
	}

	
	@Override
	public ResponseEntity<String> register(userDto uDto)
	{
		user check= productRepo.findByEmail(uDto.getEmail());
        if (check != null) {
        
        		
        		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        
        	
        	
        }
        else
        {
		user u=new user(
				uDto.getUser_id(),
				uDto.getName(),
				uDto.getEmail(),
				uDto.getPassword()
				);
		productRepo.save(u);
		return new ResponseEntity<String>(HttpStatus.CREATED);
		
        }
        
	}
	@Override
	public ResponseEntity<String> login(userDto uDto)
	{
		 String msg = "";
		 
	        user u = productRepo.findByEmail(uDto.getEmail());
	       
	        
	        if (u != null) 
	        {
	            String password = uDto.getPassword();
	            String encodedPassword = u.getPassword();
	            Boolean isPwdRight = password.matches(encodedPassword);
	            if (isPwdRight)
	            {
	                Optional<user> u1 = productRepo.findByEmailAndPassword(uDto.getEmail(), encodedPassword);
	                if (u1.isPresent()) 
	                {
	                    return new ResponseEntity<String>(HttpStatus.OK);
	                } 
	                else 
	                {
	                	return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	                }
	            } 
	            else 
	            {
	            	return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
	            }
	        }
	        else 
	        {
	        	return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	        }
	}
}
