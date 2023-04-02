package com.dev4.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dev4.models.User;
import com.github.javafaker.Faker;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {
	@Autowired
	private Faker faker;
	private List<User> usuarios = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		for(int i = 0; i<20; i++) {
			usuarios.add(new User(faker.dragonBall().character(), faker.color().hex(), faker.name().username()+ "@gmail.com"));
		}
	}
	public List<User> getUsers(){
		return usuarios;
	}
	public User getUserByUserName(String username) {
		return usuarios.stream().filter( us -> us.getUserName().equals(username)).findAny()
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s not found.", username)));
	}
	public User createUser(User user) {
		if(usuarios.stream().anyMatch( us -> us.getUserName().equals(user.getUserName())) ) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("Usuario % ya existe", user.getUserName()));
		}
		usuarios.add(user);
		return user;
	}
	
}