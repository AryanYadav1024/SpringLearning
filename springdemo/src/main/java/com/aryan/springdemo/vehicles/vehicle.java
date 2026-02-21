package com.aryan.springdemo.vehicles;

public interface vehicle {
    String start();
    String stop();
    String off();
    static void print(){
        System.out.println("hello");
    }
    public String getDiscountMessage();
    public String getEngineType();
    public String getBrandName();

    public Double getMaxRetailPrice();
}
