package com.dev4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev4.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
