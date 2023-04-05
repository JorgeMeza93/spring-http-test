package com.dev4.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev4.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
