package com.writer0713.domains;

import org.springframework.context.annotation.Bean;



public class Db {

  private String driverclass;
  private String url;
  private String username;
  private String password;

  public String getDriverclass() {
    return driverclass;
  }

  public void setDriverclass(String driverclass) {
    this.driverclass = driverclass;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Db{" +
            "driverclass='" + driverclass + '\'' +
            ", url='" + url + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            '}';
  }
}
