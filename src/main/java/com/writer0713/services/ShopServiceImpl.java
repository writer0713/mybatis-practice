package com.writer0713.services;

import com.writer0713.domains.Shop;
import com.writer0713.persistence.ShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {


  @Autowired
  private ShopDao shopDao;

  @Override
  public List<Shop> find(Shop shop) {
    return this.shopDao.list(shop);
  }

  @Override
  public Shop find(String shopNo) {
    return this.shopDao.select(shopNo);
  }

  @Transactional
  @Override
  public void add(Shop shop) {
    this.shopDao.add(shop);
  }
}
