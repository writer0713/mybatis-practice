package com.writer0713.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:properties/db.properties"})
public class DataSourceConfig {

  @Value("${driverclass}")
  private String driverClassName;

  @Value("${url}")
  private String url;

  @Value("${username}")
  private String username;

  @Value("${password}")
  private String password;

  @Bean
  public BasicDataSource basicDataSource() {

    BasicDataSource basicDataSource = new BasicDataSource();
    basicDataSource.setDriverClassName(this.driverClassName);
    basicDataSource.setUrl(this.url);
    basicDataSource.setUsername(this.username);
    basicDataSource.setPassword(this.password);

    return basicDataSource;
  }

}
