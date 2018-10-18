package com.writer0713.services;

import com.writer0713.domains.Shop;

import java.util.List;

public interface ShopService {

  public List<Shop> find(Shop shop);

  public Shop find(String shopNo);

  public void add(Shop shop);

}
