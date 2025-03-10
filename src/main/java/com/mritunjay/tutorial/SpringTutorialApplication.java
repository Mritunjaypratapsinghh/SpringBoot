package com.mritunjay.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Marks this as a Spring Boot application.
public class SpringTutorialApplication implements CommandLineRunner {

    @Autowired // Spring will automatically inject the appropriate DB implementation.
    private DB db;

    public static void main(String[] args) {
        SpringApplication.run(SpringTutorialApplication.class, args); // Starts the Spring Boot application.
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(db.getData()); // Calls getData() method from the injected DB instance.
    }
}
