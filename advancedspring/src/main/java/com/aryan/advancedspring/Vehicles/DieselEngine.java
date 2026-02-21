package com.aryan.advancedspring.Vehicles;

import org.springframework.stereotype.Component;

@Component
public class DieselEngine implements Engine{
    public void EngineType(){
        System.out.println("Diesel Engine");
    }
}
