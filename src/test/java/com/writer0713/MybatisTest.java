package com.writer0713;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/root-context.xml")
@ActiveProfiles({"dev"})
public class MybatisTest {

  private static Logger logger = LoggerFactory.getLogger(MybatisTest.class);

  @Autowired
  private SqlSessionFactory sqlSessionFactory;

  @Before
  public void changeMybatisConfiguration() {
    Configuration config = sqlSessionFactory.getConfiguration();
    config.setMapUnderscoreToCamelCase(false);
  }


  @Test
  public void testSqlSessionFactoryIsNotNull() {
    Assert.assertNotNull(this.sqlSessionFactory);
  }

  @Test
  public void testConfiguration() {
    Configuration config = this.sqlSessionFactory.getConfiguration();

    Assert.assertFalse(config.isMapUnderscoreToCamelCase());

  }
}
