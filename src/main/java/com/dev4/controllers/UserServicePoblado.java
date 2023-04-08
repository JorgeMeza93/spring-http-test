package com.dev4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dev4.entities.User;
import com.dev4.repositories.UserRepository;

@Service
public class UserServicePoblado {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(Integer id) {
		return userRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
				String.format("Usuario con id %d no encontrado", id)) );
		
	}
	
	public User getUserByUsername(String userName) {
		return userRepository.findByUsername(userName).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("Usuario con username %s no encontrado", userName)));
					
	}
	
}
