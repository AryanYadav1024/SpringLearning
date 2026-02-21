package com.aryan.springdemo.vehicles;

public class bus implements vehicle{
    private final discountService discountService; // dependency
    private final String type;
    private Double maxRetailPrice;
    private String brandName;
    private engineType engineType;
    public bus(String bus_type,discountService discountService){ // constructor dependency injection
        this.discountService = discountService; // injecting dependency
        this.type = bus_type;
    }

    public void setEngineType(engineType engineType) {
        this.engineType = engineType;
    }
    public void setBrandName(String brandName){
        this.brandName = brandName;
    }
    public String getBrandName(){
        return this.brandName;
    }
    @Override
    public String start(){
        return "bus is on";
    }
    @Override
    public String stop(){
        return "bus has stopped";
    }

    public void setMaxRetailPrice(Double maxRetailPrice) {
        this.maxRetailPrice = maxRetailPrice;
    }

    @Override
    public Double getMaxRetailPrice() {
        return this.maxRetailPrice;
    }
    @Override
    public String off(){
        return "bus is turned off";
    }
    public String getType(){
        return this.type;
    }

    @Override
    public String getDiscountMessage() {
        return this.discountService.getDiscountMessage();
    }

    @Override
    public String getEngineType() {
        return this.engineType.getEngineType();
    }
}
