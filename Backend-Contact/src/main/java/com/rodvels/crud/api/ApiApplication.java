package com.rodvels.crud.api;

import com.rodvels.crud.api.entity.Contact;
import com.rodvels.crud.api.repository.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactRepository contactRepository) {
		return args-> {
				List<Contact> contacts = Arrays.asList(
						new Contact("User 1", "example@gmail.com", LocalDateTime.now()),
						new Contact("User 2", "example@gmail.com", LocalDateTime.now()),
						new Contact("User 3", "example@gmail.com", LocalDateTime.now()),
						new Contact("User 4", "example@gmail.com", LocalDateTime.now())
						);
				contactRepository.saveAll(contacts);
		};
	}

	@Bean
	ModelMapper modelMapper  (){
		return new ModelMapper();
	}

}
