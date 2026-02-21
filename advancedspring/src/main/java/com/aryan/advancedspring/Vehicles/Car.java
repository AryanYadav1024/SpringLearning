package com.aryan.advancedspring.Vehicles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
====================================================================================
CAR BEAN — PROTOTYPE SCOPE + CONSTRUCTOR INJECTION
====================================================================================

@Component
-----------
Registers this class as a Spring bean.

Bean name default: "car"

@Scope("prototype")
-------------------
Overrides default singleton behavior.

Meaning:
- New instance created every time getBean(Car.class) is called.
- Not created at container startup.
- Spring does NOT manage destruction lifecycle.
- Not stored in singleton cache.

Prototype lifecycle:
1. BeanDefinition loaded at startup.
2. Object created only when requested.
3. Injected dependencies.
4. Returned to caller.
5. Spring forgets it.

Important:
Even though prototype is lazy-created,
Spring STILL validates dependency graph at startup.
*/

@Component
@Scope("prototype")
@Primary
public class Car implements Vehicle {

    /*
    final → promotes immutability.
    Constructor injection → mandatory dependencies.
    */

    private final String carModel;
    private final Engine engine;

    /*
    Constructor Injection
    ---------------------
    Spring resolves constructor parameters by TYPE first.

    Parameter 1:
    @Value("${car.model}")
    - Injects value from property file.
    - Placeholder resolved before bean creation.
    - If property missing → startup failure.

    Parameter 2:
    Engine engine
    - Spring searches for beans of type Engine.
    - If one found → inject.
    - If multiple found → ambiguity error unless:
         @Primary or @Qualifier used.

    This is where your earlier exception occurred.
    */

    public Car(
            @Value("${car.model}") String carModel,
            Engine engine)
    {
        this.carModel = carModel;
        this.engine = engine;
    }

    public String getCarModel() {
        return carModel;
    }
    /*
    Delegation Pattern:
    Car does not know which engine implementation.
    It depends on abstraction (Engine interface).
    This follows SOLID principle (Dependency Inversion).
    */

    public void getEngineType() {
        this.engine.EngineType();
    }
}