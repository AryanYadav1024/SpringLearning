package com.aryan.advancedspring.Vehicles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
====================================================================================
THIS CLASS REPLACES config.xml (ANNOTATION-BASED CONFIGURATION)
====================================================================================

@Configuration
--------------
Marks this class as a configuration class.
Spring treats it as metadata provider.

Internally:
- Spring creates a BeanDefinition for this class.
- It enhances this class using CGLIB proxy.
- That proxy ensures @Bean methods (if present) obey singleton semantics.

Without @Configuration:
- Spring treats it like a normal class.
- @Bean methods (if any) would NOT behave correctly.

@ComponentScan("com.aryan.advancedspring")
-------------------------------------------
Replaces <context:component-scan> from XML.

During container startup:
1. Spring scans this base package recursively.
2. Finds classes annotated with:
   - @Component
   - @Service
   - @Repository
   - @Controller
3. For each class found:
   - Creates a BeanDefinition (metadata only)
   - Registers it in beanDefinitionMap
4. Later instantiates singleton beans eagerly.

If forgotten:
- No beans are detected.
- Injection fails.

@PropertySource
---------------
Loads external property files into Spring Environment.

Process:
1. File is read at startup.
2. Key-value pairs are stored in Environment.
3. ${...} placeholders are resolved BEFORE bean instantiation.
4. Enables usage of @Value("${key}").

Multiple @PropertySource:
- Both files are loaded.
- If same key appears in both → last one overrides.
*/

@Configuration
@ComponentScan("com.aryan.advancedspring")
@PropertySource("classpath:Car.properties")
@PropertySource("classpath:Bus.properties")
public class AppConfig {
    @Bean
    public Car premiumCar(Engine engine){
        return new Car("merc",engine);
    }

    @Bean
    public Engine engine() {
        return new PetrolEngine();
    }

    /*
    This class currently contains no @Bean methods.

    If we wanted manual bean creation (instead of @Component),
    we would define:

    @Bean
    public Engine petrolEngine() {
        return new PetrolEngine();
    }

    @Bean is used when:
    - You need manual construction logic.
    - You are configuring third-party classes.
    - Constructor requires non-bean parameters.
    */

}