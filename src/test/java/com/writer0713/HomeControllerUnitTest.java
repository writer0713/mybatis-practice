package com.writer0713;

import com.writer0713.controllers.HomeController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*-context.xml"})
@WebAppConfiguration
public class HomeControllerUnitTest {

  @Autowired
  private HomeController controller;

  MockMvc mvc;

  @Before
  public void init() {
    mvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  public void getUser() throws Exception {
    MvcResult result = mvc.perform(get("/userXML")
//            .accept(MediaType.APPLICATION_JSON_VALUE))
              .accept(MediaType.APPLICATION_XML_VALUE))
            .andReturn();

    System.out.println(result.getResponse().getContentAsString());
  }
}
