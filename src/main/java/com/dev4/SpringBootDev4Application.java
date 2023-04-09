package com.dev4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev4.entities.User;
import com.dev4.repositories.UserRepository;
import com.github.javafaker.Faker;

@SpringBootApplication
public class SpringBootDev4Application implements ApplicationRunner{
	
	@Autowired
	private Faker faker;
	@Autowired
	private UserRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDev4Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		for(int i = 0; i<100; i++) {
			User usuario = new User();
			usuario.setUsername(faker.dragonBall().character());
			usuario.setPassword(faker.color().hex());
			usuario.setProfile(null);
			repository.save(usuario);
		}
		
	}

}
