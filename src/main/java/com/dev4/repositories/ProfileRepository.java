package com.dev4.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev4.entities.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer>{

}
