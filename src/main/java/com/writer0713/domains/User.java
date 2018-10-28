package com.writer0713.domains;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {

  @Size(min = 4, max = 7, message = "username은 4~7개의 캐릭터가 있어야합니다.")
  private String username;
  private String password;

  @DateTimeFormat(pattern = "yyyy-mm-dd", style = "yyyy, mm, dd")
  private Date birth;

  public Date getBirth() {
    System.out.println("set birth :: " + birth);
    return birth;
  }

  public void setBirth(Date birth) {
    System.out.println("set Birth :: " + birth);
    this.birth = birth;
  }

  public String getUsername() {
    System.out.println("get Username :: " + username);
    return username;
  }

  public void setUsername(String username) {
    System.out.println("set Username :: " + username);
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
    return "User{" +
            "username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", birth=" + birth +
            '}';
  }
}
