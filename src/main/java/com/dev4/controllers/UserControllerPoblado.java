package com.dev4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev4.entities.User;

@RestController
@RequestMapping("/poblados/usuarios")
public class UserControllerPoblado {
	@Autowired
	private UserServicePoblado userService;
	
	@GetMapping
	public ResponseEntity<Page<User>> getUsers(@RequestParam(required = false, value="page", defaultValue = "0") 
		int page, @RequestParam(required = false, value  = "size", defaultValue = "5") int size){
		return new ResponseEntity<Page<User>>(userService.getUsers(page, size), HttpStatus.OK);
	}
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId){
		return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
	}
	@GetMapping("/user/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username){
		return new ResponseEntity<User>(userService.getUserByUsername(username), HttpStatus.OK);
	}
}
