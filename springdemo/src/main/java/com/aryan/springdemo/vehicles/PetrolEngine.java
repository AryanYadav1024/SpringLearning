package com.aryan.springdemo.vehicles;

public class PetrolEngine implements engineType{
    private String engineCC;
    public PetrolEngine(String engineCC){
        this.engineCC = engineCC;
    }
    @Override
    public String getEngineType() {
        return "Petrol Engine" + this.engineCC;
    }
}
