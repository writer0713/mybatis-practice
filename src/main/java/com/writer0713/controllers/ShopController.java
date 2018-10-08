package com.writer0713.controllers;

import com.writer0713.domains.Shop;
import com.writer0713.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/shop")
public class ShopController {

  @Autowired
  private ShopService shopService;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public List<Shop> list(Shop shop) throws Exception {
    List<Shop> shopList = shopService.find(shop);

    return shopList;
  }
}
