package com.writer0713.persistence;

import com.writer0713.domains.Shop;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShopDaoImpl implements ShopDao {
  @Override
  public List<Shop> list(Shop shop) {
    List<Shop> shopList = new ArrayList<>();
    shopList.add(new Shop(1, "Toy Store", "A Tower Seocho dong", "Y"));
    shopList.add(new Shop(2, "Play Store", "B Tower Seocho dong", "Y"));
    shopList.add(new Shop(3, "Mom Store", "C Tower Seocho dong", "Y"));

    return shopList;

  }
}
