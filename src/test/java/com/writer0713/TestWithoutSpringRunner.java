package com.writer0713;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.io.IOException;

public class TestWithoutSpringRunner {

    private ApplicationContext ac;

    private SimpleDriverDataSource dataSource;

    @Test
    public void testPathMatchingResourceResolver() throws IOException {
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("spring/*.xml");

        System.out.println(resources.length);

        for(Resource resource : resources) {
            System.out.println(resource.getURI());
        }
    }



}
