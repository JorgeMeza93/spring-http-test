package com.dev4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
	public Role updateRole(Integer roleId, Role role) {
		Optional<Role> resultado = repository.findById(roleId);
		if(resultado.isPresent()) {
			return repository.save(role);
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role con id %d no existe", roleId));
		}
	}
	public void deleteRole(Integer id) {
		Optional<Role> resultado = repository.findById(id);
		if(resultado.isPresent()) {
			repository.deleteById(id);
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role con id %d no existe", id));
		}
		
	}
	
}
