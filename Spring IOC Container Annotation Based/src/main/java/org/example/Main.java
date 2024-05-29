package org.example;

import com.spring.core.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Creating Spring IoC Container
        //Read the configuration class
        //Create & Manage the Spring Beans
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //Retrieve Spring Beans from Spring IoC Container
        Bike bike = applicationContext.getBean(Bike.class);
        bike.move();

        Car car = applicationContext.getBean(Car.class);
        car.move();

        Traveller traveller = applicationContext.getBean(Traveller.class);
        traveller.startJourney();
    }
}