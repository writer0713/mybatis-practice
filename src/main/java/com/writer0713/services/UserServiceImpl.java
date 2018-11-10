package com.writer0713.services;

import com.writer0713.aspect.CustomLogging;
import com.writer0713.domains.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

	@CustomLogging
	@Override
	public User getUser() {
		User user = new User();
		user.setUsername("kim");
		user.setPassword("password for kim");
		user.setBirth(new Date());
		user.setHobbies(new String[]{"soccer"});
		return user;
	}
}
