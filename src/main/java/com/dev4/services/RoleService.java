package com.dev4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev4.entities.Role;
import com.dev4.repositories.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository repository;
	
	public List<Role> getRoles(){
		List<Role> findAll = repository.findAll();
		return findAll;
	}
	public Role createRole(Role role) {
		return repository.save(role);
	}
	
}
