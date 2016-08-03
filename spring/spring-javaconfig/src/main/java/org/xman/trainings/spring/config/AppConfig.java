package org.xman.trainings.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.xman.trainings.spring.hello.HelloWorld;
import org.xman.trainings.spring.hello.impl.HelloWorldImpl;

@Configuration
public class AppConfig {

    @Bean(name = "helloBean")
    public HelloWorld helloWorld() {
        return new HelloWorldImpl();
    }

}