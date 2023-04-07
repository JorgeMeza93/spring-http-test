package com.dev4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev4.entities.User;
import com.dev4.repositories.UserRepository;

@Service
public class UserServicePoblado {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
}
