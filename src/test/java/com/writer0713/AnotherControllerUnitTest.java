package com.writer0713;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.writer0713.controllers.AnotherController;
import com.writer0713.domains.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
@WebAppConfiguration
public class AnotherControllerUnitTest {


  @Autowired
  WebApplicationContext ac;

  MockMvc mvc;

  @Before
  public void init() {
    mvc = MockMvcBuilders.webAppContextSetup(ac).build();
  }

  @Test
  public void acNotNull() {
    Assert.assertNotNull(ac);
  }

  @Test
  public void dateFormatTest() throws Exception {
    MvcResult result = mvc.perform(get("/another/date").param("date", "1989**07**13"))
            .andExpect(status().isOk())
            .andReturn();

    String content = result.getResponse().getContentAsString();

    System.out.println(content);
  }

  @Test
  public void userTest() throws Exception {

    User user = new User();
    user.setUsername("kim11");
    user.setPassword("password");
    user.setBirth(new Date());

    ObjectMapper mapper = new ObjectMapper();
    String jsonValue = mapper.writeValueAsString(user);

    System.out.println(jsonValue);

    MvcResult result = mvc.perform(
      get("/another/user").content(jsonValue).contentType(MediaType.APPLICATION_JSON_VALUE))
        .andReturn();

    Exception ex = result.getResolvedException();
    if(ex != null) System.out.println(ex.getMessage());

    String content = result.getResponse().getContentAsString();
    System.out.println(content);

  }

}
