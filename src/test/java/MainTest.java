import com.writer0713.domains.Db;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @RunWith(SpringJUnit4ClassRunner.class) 를 사용해야 실제 스프링에 사용되는 빈을 설정하여 불러올수있다
 * @ContextConfiguration(locations = {...}) 을 사용하여 빈 컨텍스트를 불러오도록 한다
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/servlet-context.xml"})
public class MainTest {

  @Autowired
  Db db;

  @Test
  public void test() {
    assert(db != null);
  }
}
