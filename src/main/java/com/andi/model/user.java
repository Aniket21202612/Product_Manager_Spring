package com.andi.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name="user")
public class user {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false, unique=true)
	private String email;
	@Column(nullable=false)
	private String password;

	
	public user() {
		
	}
	
	public user(int user_id, String name, String email, String password) {
		
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public user(String email) {
		
		this.email = email;
	}


	public user(String email, String password) {
		
		this.email = email;
		this.password = password;
	}


	


	public user(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;	
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}


	
		
