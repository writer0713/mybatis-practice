package com.writer0713;

import com.writer0713.domains.Db;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class TestWithoutSpringRunner {

    private ApplicationContext ac;

    private SimpleDriverDataSource dataSource;

    @Before
    public void setting() {
        ac = new ClassPathXmlApplicationContext("spring/mybatis-context.xml");
    }

    @Test
    public void testDataSourceIsNotNull() {
        this.dataSource = this.ac.getBean(SimpleDriverDataSource.class);
        Assert.assertNotNull(this.dataSource);
    }



}
