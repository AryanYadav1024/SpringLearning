package com.aryan.springdemo.vehicles;

public class MyApp {
    public static void main(String[] args) {

        /*
        ============================================================
        WHY DO WE NEED SPRING?
        ============================================================

        Right now, we are manually creating objects:

            Car car = new Car("merc");
            Vehicle bus = new Bus("Neu_go");

        This is HARD CODING.

        Problems with this approach:

        1) Tight Coupling:
           MyApp directly decides WHICH implementation to use.
           If tomorrow we want ElectricCar instead of Car,
           we must modify source code and recompile.

        2) No Flexibility:
           Object creation logic is mixed with business logic.

        3) No Lifecycle Management:
           We manually control creation & destruction.

        4) No Centralized Object Graph:
           Dependencies are scattered across the app.


        ============================================================
        SPRING SOLUTION
        ============================================================

        Instead of manually writing `new`,
        we EXTERNALIZE object creation.

        Important Concept:
        --> We DECLARE dependencies.
        --> Spring BUILDS the object graph.

        That is the shift.


        ============================================================
        IoC (Inversion of Control)
        ============================================================

        Normally:
            We control object creation.

        With Spring:
            We give control to the IoC container.

        Spring:
            - Instantiates objects (beans)
            - Resolves dependencies
            - Injects dependencies
            - Manages lifecycle
            - Stores beans inside container (usually singleton)

        IoC = Control of object creation is inverted (given to Spring).


        ============================================================
        DI (Dependency Injection)
        ============================================================

        DI is HOW IoC is implemented.

        Instead of:

            new Engine()

        We write:

            public Car(Engine engine)

        And Spring injects Engine automatically.

        Types of DI:

        1) Constructor Injection  (RECOMMENDED)
           - Makes dependencies explicit
           - Supports immutability
           - Better for testing
           - Fail-fast at startup

        2) Field Injection
           - Shorter
           - Harder to test
           - Less explicit

        3) Setter Injection
           - Optional dependencies
           - Rare in modern Spring


        ============================================================
        METADATA IN SPRING
        ============================================================

        We DO NOT write object creation logic directly.

        We provide METADATA.

        Metadata = data that describes how objects should be created.

        Spring reads metadata and builds everything.

        Ways to provide metadata:

        1) XML Configuration
        2) Annotations (@Component, @Service, etc.)
        3) Java Configuration class (@Configuration + @Bean)

        Modern Spring Boot = Mostly Annotation based.


        ============================================================
        IoC CONTAINER
        ============================================================

        The IoC Container is responsible for:

        - Instantiating beans
        - Configuring beans
        - Managing lifecycle
        - Resolving dependencies
        - Storing beans in container (usually singleton map)

        Internally:
            Map<String, Object> singletonObjects

        Container builds dependency graph like:

            TransportService
                ↓
            Vehicle
                ↓
            Car / Bus


        ============================================================
        TYPES OF IoC CONTAINERS
        ============================================================

        1) BeanFactory
           - Basic IoC features
           - Lazy initialization
           - Less memory
           - Rarely used directly

        2) ApplicationContext
           - Advanced features
           - Eager initialization (default)
           - Supports AOP
           - Supports events
           - Supports internationalization
           - Most commonly used

        ApplicationContext IS an IoC container.
        It extends BeanFactory.


        ============================================================
        HOW SPRING CREATES OBJECTS INTERNALLY
        ============================================================

        1) Reads configuration metadata
        2) Creates BeanDefinition objects
        3) Resolves constructor dependencies
        4) Instantiates using reflection
        5) Injects dependencies
        6) Stores in singleton cache

        Spring DOES use `new`,
        but internally via reflection,
        not in our business code.


        ============================================================
        KEY MINDSET SHIFT
        ============================================================

        Manual World:
            new A(new B(new C()))

        Spring World:
            class A(B b)
            class B(C c)

            Spring figures out the nesting automatically.

        We declare.
        Spring assembles.


        ============================================================
        IMPORTANT RULE
        ============================================================

        If you manually write:

            new Car()

        inside a Spring-managed class,

        Then:
            - Spring cannot inject dependencies into it
            - No AOP
            - No lifecycle callbacks
            - No proxy wrapping

        Always let Spring manage beans.


        ============================================================
        SUMMARY
        ============================================================

        Spring is NOT about avoiding `new`.

        It is about:
        - Centralized object creation
        - Dependency graph management
        - Loose coupling
        - Lifecycle control
        - Scalable architecture

        That is why enterprise systems use it.

        */


        car car = new car("merc",new FestivalDiscount());
        vehicle bus = new bus("Neu_go",new FestivalDiscount());

        System.out.println(car.start());
        vehicle.print();
    }
}
