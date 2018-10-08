package com.writer0713.domains;

import java.io.Serializable;

public class Shop implements Serializable {

  private int shopNo;
  private String shopName;
  private String shopLocation;
  private String shopStatus;

  public Shop() {

  }

  public Shop(int shopNo, String shopName, String shopLocation, String shopStatus) {
    this.shopNo = shopNo;
    this.shopName = shopName;
    this.shopLocation = shopLocation;
    this.shopStatus = shopStatus;
  }

  public int getShopNo() {
    return shopNo;
  }

  public void setShopNo(int shopNo) {
    this.shopNo = shopNo;
  }

  public String getShopName() {
    return shopName;
  }

  public void setShopName(String shopName) {
    this.shopName = shopName;
  }

  public String getShopLocation() {
    return shopLocation;
  }

  public void setShopLocation(String shopLocation) {
    this.shopLocation = shopLocation;
  }

  public String getShopStatus() {
    return shopStatus;
  }

  public void setShopStatus(String shopStatus) {
    this.shopStatus = shopStatus;
  }
}
