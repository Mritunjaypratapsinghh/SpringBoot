package com.mritunjay.tutorial.configuration;

import com.mritunjay.tutorial.DB;
import com.mritunjay.tutorial.DevDB;
import com.mritunjay.tutorial.ProdDB;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Marks this class as a configuration class for Spring.
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "development")
    public DB getDevDBBean() {
        return new DevDB(); // Creates a DevDB bean if project.mode=development
    }

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "production")
    public DB getProdDBBean() {
        return new ProdDB(); // Creates a ProdDB bean if project.mode=production
    }
}
