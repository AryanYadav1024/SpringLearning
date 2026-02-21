package com.aryan.advancedspring.Vehicles;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
====================================================================================
APPLICATION ENTRY POINT
====================================================================================

Spring is NOT active until ApplicationContext is created.

AnnotationConfigApplicationContext:
- Reads @Configuration class.
- Performs component scan.
- Loads property sources.
- Creates BeanDefinitions.
- Instantiates singleton beans eagerly.
- Validates dependency graph.

Important:
Car is prototype → NOT instantiated at startup.
Engines are singleton → instantiated at startup.
*/

public class MyApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        /*
        When getBean(Car.class) is called:
        - Spring creates new Car instance.
        - Injects Engine.
        - Injects car.model.
        */

        Car car1 = context.getBean(Car.class);
        Car car2 = context.getBean(Car.class);
        System.out.println(car1.getCarModel());
        Car car3 = (Car) context.getBean("premiumCar");

        /*
        Since Car is prototype:
        car1 == car2 → false
        */

        System.out.println(car1 == car2);
        System.out.println(car3.getCarModel());
        car1.getEngineType();

        /*
        On context.close():
        - Singleton beans receive destroy callbacks.
        - Prototype beans DO NOT receive destroy callbacks.
        */

        context.close();
    }
}