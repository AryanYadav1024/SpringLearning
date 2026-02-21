package com.aryan.advancedspring.Vehicles;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*
====================================================================================
ENGINE IMPLEMENTATION — PETROL
====================================================================================

@Component
-----------
Marks this class as Spring-managed bean.

During component scan:
1. Spring detects this class.
2. Creates BeanDefinition.
3. Registers bean with default name: "petrolEngine"
   (class name with lowercase first letter).
4. Default scope → singleton.

Singleton means:
- Only ONE PetrolEngine instance per container.
- Created eagerly during container startup.
- Stored inside singletonObjects cache.
*/

@Component
@Primary
public class PetrolEngine implements Engine {

    /*
    Method naming note:
    Java convention recommends camelCase method names.
    So ideally: engineType()

    This method represents business behavior.
    No dependency injection here.
    */

    public void EngineType() {
        System.out.println("Petrol Engine");
    }
}