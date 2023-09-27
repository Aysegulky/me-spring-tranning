package com.cydeo.bootstrap;

import com.cydeo.entity.Car;
import org.springframework.boot.CommandLineRunner;

public class DataGenerator implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Car car1 = new Car("BMV", "M3");
        Car car2 = new Car("Honda", "Civic");
        Car car3 = new Car("Toyota", "Corolla");



    }
}
