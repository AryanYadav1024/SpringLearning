package com.aryan.advancedspring.Vehicles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope("prototype")
public class Bus implements Vehicle{
    private String carModel;
    private Engine Engine;
    public Bus(
            @Value("${bus.model}")
            String carModel, Engine Engine)
    {
        this.carModel = carModel;
        this.Engine = Engine;
    }

    public void getEngineType() {
        this.Engine.EngineType();
    }
}
