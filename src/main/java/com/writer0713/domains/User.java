package com.writer0713.domains;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.Date;

@XmlRootElement(name = "user")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class User {

  @Size(min = 4, max = 7, message = "username은 4~7개의 캐릭터가 있어야합니다.")
  private String username;
  private String password;

  @DateTimeFormat(pattern = "yyyy-mm-dd")
  private Date birth;

  private String[] hobbies;

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

  public String[] getHobbies() {
    return hobbies;
  }

  public void setHobbies(String[] hobbies) {
    this.hobbies = hobbies;
  }

  @Override
  public String toString() {
    return "User{" +
            "username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", birth=" + birth +
            ", hobbies=" + Arrays.toString(hobbies) +
            '}';
  }
}
