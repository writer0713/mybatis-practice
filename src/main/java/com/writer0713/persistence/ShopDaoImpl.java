package com.writer0713.persistence;

import com.writer0713.domains.Shop;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopDaoImpl implements ShopDao {


  private static final String namespace = "com.writer0713.persistence.ShopMapper.";

  @Autowired
  private SqlSessionTemplate sqlSessionTemplate;

  @Override
  public List<Shop> list(Shop shop) {
    List<Shop> shopList = this.sqlSessionTemplate.selectList(namespace +"list", shop);
    return shopList;
  }

  @Override
  public Shop select(String shopNo) {
    Shop shop = this.sqlSessionTemplate.selectOne(namespace + "selectWithShopNo", shopNo);
    return shop;
  }

  @Override
  public void add(Shop shop) {
    this.sqlSessionTemplate.insert(namespace + "insert", shop);
  }
}
