package com.dev4.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dev4.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public Optional<User> findByUsername(String username);
	
	/* No es SQL es JPQL */
	@Query("SELECT u.username FROM User u WHERE u.username LIKE 'G%'")
	public Page<String> findUsernames(Pageable pageable); 

}
