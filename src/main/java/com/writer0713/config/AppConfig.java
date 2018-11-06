package com.writer0713.config;

import com.writer0713.domains.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:properties/user.properties"})
public class AppConfig {

	@Value("${papago.name}")
	private String name;

	@Value("${papago.password}")
	private String password;

	@Bean
	public User user() {
		User user = new User();
		user.setUsername(name);
		user.setPassword(password);
		return user;
	}
}
