package com.aryan.springdemo.vehicles;

public class car implements vehicle{
    private final discountService discountService; // If I were to directly write new FestivalDiscount() that would be hard coupling ( hard dependency )
    // but now it is loose coupling ( loose dependency ) as spring decides what to implement
    private engineType engineType;
    private String brandName;
    private final String type;
    private Double maxRetailPrcie;
    public car(String car_type,discountService discountService){
        this.discountService = discountService;
        this.type = car_type;
    }
    public void setEngineType(engineType engineType){ // clearing dependency through setter
        // dangerous if we tried calling method getEngineType from engineType, but currently we don't have full bean created
        // as dependency is not resolved it may cause nullPointerException
        this.engineType = engineType;
    }
    public void setBrandName(String brandName){
        this.brandName = brandName;
    }
    public String getBrandName(){
        return this.brandName;
    }

    public void setMaxRetailPrice(Double maxRetailPrice) {
        this.maxRetailPrcie = maxRetailPrice;
    }

    @Override
    public Double getMaxRetailPrice() {
       return this.maxRetailPrcie;
    }

    @Override
    public String start(){
        return "car is on";
    }
    @Override
    public String stop(){
        return "car has stopped";
    }
    @Override
    public String off(){
        return "car is turned off";
    }
    public String getType(){
        return this.type;
    }

    @Override
    public String getDiscountMessage() {
        return this.discountService.getDiscountMessage();
    }
    @Override
    public String getEngineType(){
        return this.engineType.getEngineType();
    }
}
