package com.spring.core;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {
    @Override
    public void move() {
        System.out.println("Car is moving..");
    }
}
