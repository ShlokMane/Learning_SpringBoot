package com.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.spring.core")
public class AppConfig {

//    @Bean
//    public Vehicle car() {
//        return new Car();
//    }
//
//    @Bean
//    public Vehicle bike() {
//        return new Bike();
//    }
//
//    @Bean
//    public Vehicle cycle() {
//        return new Cycle();
//    }
//
//    @Bean
//    public Traveller traveller() {
//        return new Traveller(bike());
//    }
}
