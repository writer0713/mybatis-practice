package com.writer0713.controllers;

import com.writer0713.domains.Shop;
import com.writer0713.services.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.util.List;

@Controller
@RequestMapping(value = "/shop")
public class ShopController {

  private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

  @Autowired
  private ShopService shopService;

  public ShopController() {
  }

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(String.class, "shopStatus", new PropertyEditorSupport() {

      @Override
      public void setAsText(String shopStatus) throws IllegalArgumentException {

        if(StringUtils.isEmpty(shopStatus) || "N".equals(shopStatus) ) {
          shopStatus = "N";
        } else {
          shopStatus = "Y";
        }

        this.setValue(shopStatus);
      }
    });
  }

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public @ResponseBody List<Shop> list(Shop shop) throws Exception {
    List<Shop> shopList = shopService.find(shop);

    return shopList;
  }

  @RequestMapping(value = "/{shopNo}", method = RequestMethod.GET)
  public @ResponseBody Shop selectShopWith(@PathVariable String shopNo) {

    Shop shop = shopService.find(shopNo);

    return shop;
  }

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public String addForm() {
    return "shopAddForm";
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public String add(Shop shop) {

    shopService.add(shop);

    logger.info("shop add ::");

    return "redirect:/shop/list";
  }


}
