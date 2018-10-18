package com.writer0713.persistence;

import com.writer0713.domains.Shop;

import java.util.List;

public interface ShopDao {
  public List<Shop> list(Shop shop);

  public Shop select(String shopNo);

  public void add(Shop shop);
}
