package com.writer0713;

import com.writer0713.domains.User;
import com.writer0713.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.WebApplicationContext;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*-context.xml"})
@WebAppConfiguration
public class AnotherControllerTest {

	private final static String XML_FILE_NAME = "classpath:xmlDatas/user.xml";
	@Autowired
	private Marshaller marshaller;

	@Autowired
	private Unmarshaller unmarshaller;

	@Autowired
	private UserService userService;

	@Test
	public void testUnMarshall() throws Exception {
		try (FileInputStream fis = new FileInputStream(ResourceUtils.getFile(XML_FILE_NAME))) {
			User user = (User) unmarshaller.unmarshal(new StreamSource(fis));
			System.out.println(user);
		}

	}

	@Test
	public void testMarshall() throws IOException {
		User user = new User();
		user.setUsername("park");
		user.setPassword("parkpass");
		user.setBirth(new Date());
		user.setHobbies(new String[]{"soccer"});

		try (FileOutputStream fos = new FileOutputStream(ResourceUtils.getFile(XML_FILE_NAME))) {
			marshaller.marshal(user, new StreamResult(fos));
		}

	}

	@Test
	public void testLoggingAnnotation() {
		User user = this.userService.getUser();
		System.out.println(user.toString());
	}

}
