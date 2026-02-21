package com.aryan.springdemo.vehicles;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
====================================================================================
THIS CLASS IS THE ENTRY POINT OF THE APPLICATION
====================================================================================

The JVM starts execution from main().

Spring is NOT active until we explicitly create the ApplicationContext.

Important Concept:
Spring is just a library running inside the JVM.
It does not replace JVM.
It does not modify compilation.
It operates entirely at runtime.
*/

public class MySpringApp {

    public static void main(String[] args) {

        /*
        =============================================================================
        STEP 1 — CREATE IoC CONTAINER
        =============================================================================

        This line does EVERYTHING.

        What happens internally:

        1) JVM loads ClassPathXmlApplicationContext class.
        2) Constructor reads config.xml from classpath.
        3) Spring parses XML.
        4) Creates BeanDefinition objects (metadata representation of beans).
        5) Registers BeanDefinitions in BeanFactory.
        6) Resolves property placeholders (${...}) BEFORE bean creation.
        7) Instantiates singleton beans eagerly.
        8) Performs constructor injection.
        9) Performs setter injection (populateBean phase).
        10) Stores fully constructed beans in singleton cache.

        At this moment:
        - IoC has happened (Spring controls object lifecycle).
        - DI has happened (dependencies injected).

        Internally, Spring now has:

        Map<String, Object> singletonObjects;

        which stores all singleton beans.
        */

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("config.xml");


        /*
        =============================================================================
        STEP 2 — REQUESTING BEANS
        =============================================================================

        getBean(String name, Class<T> requiredType)

        This method:
        - Looks up bean by ID.
        - Checks if bean is assignable to requiredType.
        - Returns bean safely using generics.

        No object creation happens here.
        Objects were already created during container initialization.
        */

        vehicle myVehicle = context.getBean("myVehicle", vehicle.class);
        vehicle myVehicle2 = context.getBean("myVehicle",bus.class);
        System.out.println(myVehicle==myVehicle2);
        vehicle car = context.getBean("car", vehicle.class);
        vehicle car2 = context.getBean("car", vehicle.class);
        System.out.println(car==car2);
        // singleton bean scope as only one object is created and all are pointing that only
        /*
        Why use interface type (vehicle)?

        Because:
        - We want loose coupling.
        - We do not want Java code dependent on concrete implementation.
        - We can change XML implementation without modifying this file.
        */

        System.out.println(car.getBrandName());
        System.out.println(myVehicle.start());
        System.out.println(myVehicle.getDiscountMessage());
        System.out.println(myVehicle.getEngineType());
        System.out.println(myVehicle.getBrandName());
        System.out.println(myVehicle.getMaxRetailPrice());

        /*
        Always close context.

        Why?
        - Triggers destroy lifecycle methods.
        - Releases resources.
        */


        context.close();
/*
====================================================================================
ADDITIONAL NOTES — BEAN SCOPE + INTERNAL CONTAINER MECHANICS
====================================================================================

1) IMPORTANT: SCOPE IMPACT ON CREATION

Even though XML is parsed before getBean() is called,
actual bean instantiation depends on SCOPE.

During container initialization:

- Spring loads ALL BeanDefinitions into beanDefinitionMap.
- Spring eagerly creates ONLY singleton beans.
- Prototype beans are NOT created at startup.
- They are created only when getBean() is invoked.

So in this application:

bus (myVehicle) → singleton (default) → created at startup.
car → prototype → NOT created at startup.

When we call:

vehicle car = context.getBean("car", vehicle.class);

Spring does:
- Look up BeanDefinition
- Detect scope = prototype
- Call createBean()
- Return new instance
- DOES NOT cache it

Calling getBean("car") again:
- Repeats full creation process
- Returns different instance

That is why:
System.out.println(car == car2); → false


2) WHAT HAPPENS INTERNALLY WHEN getBean() IS CALLED?

Pseudo-internal logic:

if (bean is singleton) {
    return singletonObjects.get(beanName);
}
else if (bean is prototype) {
    return createBean(beanName);
}

Singleton objects live inside:

DefaultSingletonBeanRegistry → Map<String, Object> singletonObjects


3) WHY PROTOTYPE IS NOT STORED?

Because storing it would defeat the purpose of:
"New instance per request."

Spring keeps only the blueprint (BeanDefinition).
Not the actual object.


4) IMPORTANT EDGE CASE

If a prototype bean is injected into a singleton:

The prototype will be created ONCE during singleton creation.

It will NOT create new instance per method call.

To truly get new prototype every time inside singleton,
we would need:
- ObjectProvider
- ApplicationContext.getBean()
- @Lookup method injection


5) THREAD SAFETY NOTE

Singleton beans are shared across all threads.

Spring does NOT make them thread-safe.

If mutable state is stored inside singleton,
developer must ensure synchronization.


6) FINAL MENTAL MODEL

Container initialization = Build blueprints + instantiate singletons.
getBean() = Fetch existing singleton OR create prototype on demand.

Spring is NOT executing XML line by line.
It builds a dependency graph and manages object lifecycle.

====================================================================================
*/
    }
}