package com.writer0713;

import com.writer0713.config.AppConfig;
import com.writer0713.domains.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class AnnotationConfigTest {

	@Autowired
	User user;

	@Autowired
	Environment env;

	@Value("${papago.name}")
	private String name;

	@Before
	public void setup() {

	}

	@Test
	public void testUser() {
		System.out.println(user);
	}

	@Test
	public void testValuesFromProperties() {
		System.out.println(name);
	}

	@Test
	public void testValuesFromEnvironment() {
		System.out.println(env.getProperty("papago.name"));
		System.out.println(env.getProperty("papago.password"));
	}

}
