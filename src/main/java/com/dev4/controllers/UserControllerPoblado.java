package com.dev4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev4.entities.User;

@RestController
@RequestMapping("/poblados/usuarios")
public class UserControllerPoblado {
	@Autowired
	private UserServicePoblado userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
	}
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId){
		return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
	}
	
}
