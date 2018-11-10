package com.writer0713.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Size;
import java.util.Date;

public class User {

  @Size(min = 4, max = 7, message = "username은 4~7개의 캐릭터가 있어야합니다.")
  private String username;
  private String password;

  @JsonFormat(pattern = "yyyy****MM****dd")
  private Date birth;

  @NumberFormat(pattern = "#,###")
  private long money;

  public Date getBirth() {
    return birth;
  }

  public void setBirth(Date birth) {
    this.birth = birth;
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

  public long getMoney() {
    return money;
  }

  public void setMoney(long money) {
    this.money = money;
  }

  @Override
  public String toString() {
    return "User{" +
            "username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", birth=" + birth +
            ", money=" + money +
            '}';
  }
}
