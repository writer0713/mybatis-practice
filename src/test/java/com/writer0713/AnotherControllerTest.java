package com.writer0713;

import com.writer0713.domains.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context.xml"})
@WebAppConfiguration
public class AnotherControllerTest {

	private final static String XML_FILE_NAME = "classpath:xmlDatas/user.xml";
	@Autowired
	private Marshaller marshaller;

	@Autowired
	private Unmarshaller unmarshaller;

	@Autowired
	private WebApplicationContext cx;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(cx).build();
	}

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

}
