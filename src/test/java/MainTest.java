import com.writer0713.domains.Shop;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @RunWith(SpringJUnit4ClassRunner.class) 를 사용해야 실제 스프링에 사용되는 빈을 설정하여 불러올수있다
 * @ContextConfiguration(locations = {...}) 을 사용하여 빈 컨텍스트를 불러오도록 한다
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/servlet-context.xml"})
public class MainTest {

  @Autowired
  private SqlSessionTemplate sqlSessionTemplate;

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
}
