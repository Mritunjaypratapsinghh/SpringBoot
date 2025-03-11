package com.mritunjay.tutorial.configuration;

import com.mritunjay.tutorial.DB;
import com.mritunjay.tutorial.DevDB;
import com.mritunjay.tutorial.ProdDB;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Marks this class as a Spring configuration class
public class AppConfig {

    /**
     * Creates a DevDB bean if the property `project.mode=development` is set in `application.properties`
     */
    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "development")
    public DB getDevDBBean() {
        return new DevDB();
    }

    /**
     * Creates a ProdDB bean if the property `project.mode=production` is set in `application.properties`
     */
    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "production")
    public DB getProdDBBean() {
        return new ProdDB();
    }

    /**
     * Creates a ModelMapper bean for object mapping
     */
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
