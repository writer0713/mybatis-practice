package com.writer0713;

import com.writer0713.domains.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.context.WebApplicationContext;

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

	@Autowired
	private Jaxb2Marshaller marshaller;

	@Autowired
	private WebApplicationContext cx;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(cx).build();
	}


	@Test
	public void makeUserToXml() {
		User user = new User();
		user.setUsername("kim");
		user.setPassword("pass");
		user.setBirth(new Date());
		user.setHobbies(new String[]{"swim"});

		try (FileOutputStream os = new FileOutputStream("src/main/resources/xmlDatas/user.xml")) {
			marshaller.marshal(user, new StreamResult(os));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void xmlToUserObject() {
		User user = null;
		try (FileInputStream os = new FileInputStream("src/main/resources/xmlDatas/user.xml")) {
			user = (User) marshaller.unmarshal(new StreamSource(os));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println(user);
		}
	}

	@Test
	public void requestUserObj() throws Exception {
		final ResultActions result = mockMvc.perform(
				get("/another/user.obj")
						.accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

		result.andExpect(status().isOk());
	}
}
