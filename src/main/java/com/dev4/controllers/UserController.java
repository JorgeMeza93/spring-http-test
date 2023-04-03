package com.dev4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev4.models.User;
import com.dev4.services.UserService;

@RestController
@RequestMapping("/usuarios")   // Definición del recurso
public class UserController {
	
	@Autowired
	private UserService userService;
	@GetMapping
	// Método HTTP + Recurso -> Handler Method
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
	}
	@GetMapping(value="/{username}")
	public ResponseEntity<User> getUserByUserName(@PathVariable("username") String username){
		return new ResponseEntity<User>(userService.getUserByUserName(username), HttpStatus.OK); 
	}
	
	@PostMapping()
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}
	@PatchMapping(value="/{username}")
	public ResponseEntity<User> updateUser(@PathVariable("username") String username, @RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user, username), HttpStatus.OK);
	}
	@DeleteMapping("/{username}")
	public ResponseEntity<Void> deleteUser(@PathVariable("username") String username){
		userService.deleteUser(username);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/param")
	public ResponseEntity<List<User>> getUsers(@RequestParam(required = false, value="startswith") String startsWith){
		return new ResponseEntity<List<User>>(userService.getUsersParam(startsWith), HttpStatus.OK);
	}
	
	
}
