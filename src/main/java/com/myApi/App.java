package com.myApi;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Hello world!
 *
 */

 @SpringBootApplication
 @EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class App extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication app = new SpringApplication(App.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8080"));
        app.run(args);
        System.out.println( "Hello World!" );
    }
}
