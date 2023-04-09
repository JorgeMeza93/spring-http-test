package com.dev4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dev4.entities.User;
import com.dev4.repositories.UserRepository;

@Service
public class UserServicePoblado {

	@Autowired
	private UserRepository userRepository;
	
	public Page<User> getUsers(int page, int size){
		return userRepository.findAll(PageRequest.of(page, size));
		
	}
	
	public User getUserById(Integer id) {
		return userRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
				String.format("Usuario con id %d no encontrado", id)) );
		
	}
	
	public User getUserByUsername(String userName) {
		return userRepository.findByUsername(userName).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("Usuario con username %s no encontrado", userName)));
					
	}
	
	public Page<String> getUsernames(int page, int size){
		return userRepository.findUsernames(PageRequest.of(page, size));
	}
	
}
