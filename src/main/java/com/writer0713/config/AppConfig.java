package com.writer0713.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public PersonService personService() {
		return new PersonService();
	}
}
