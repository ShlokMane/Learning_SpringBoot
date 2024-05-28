package org.example;

import com.spring.core.Bike;
import com.spring.core.Car;
import com.spring.core.Cycle;
import com.spring.core.Traveller;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Traveller traveller = new Traveller(new Bike());
        traveller.startJourney();
    }
}