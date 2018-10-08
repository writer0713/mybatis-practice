package com.writer0713.persistence;

import com.writer0713.domains.Shop;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopDaoImpl implements ShopDao {

  @Autowired
  private SqlSessionTemplate sqlSessionTemplate;

  @Override
  public List<Shop> list(Shop shop) {
    List<Shop> shopList = this.sqlSessionTemplate.selectList("com.writer0713.persistence.ShopMapper.list", shop);
    return shopList;
  }
}
