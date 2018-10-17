package com.writer0713;

import com.writer0713.domains.Shop;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @RunWith(SpringJUnit4ClassRunner.class) 를 사용해야 실제 스프링에 사용되는 빈을 설정하여 불러올수있다
 * @ContextConfiguration(locations = {...}) 을 사용하여 빈 컨텍스트를 불러오도록 한다
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context.xml"})
@ActiveProfiles({"dev"})
public class MainTest {

  private static final Logger logger = LoggerFactory.getLogger(MainTest.class);

  @Autowired
  private Environment env;

  @Autowired
  private SqlSessionTemplate sqlSessionTemplate;

  @Test
  public void testEnv() {
    logger.info("{}", this.env);
  }

  @Test
  public void testSqlSessionTemplateExists() {
    Assert.assertNotNull(this.sqlSessionTemplate);
  }

  @Test
  public void testSelectShopLists() {
    Shop shop = new Shop();
    List<Shop> shopList = this.sqlSessionTemplate.selectList("com.writer0713.persistence.ShopMapper.list", shop);
    shopList.forEach(_shop -> System.out.println(_shop.toString()));

  }

  @Test
  public void testLogger() {

    this.logger.debug("{}", "debug logging");
    this.logger.info("{}", "info logging");
    this.logger.warn("{}", "warn logging");
    this.logger.error("{}", "error logging");
  }
}
