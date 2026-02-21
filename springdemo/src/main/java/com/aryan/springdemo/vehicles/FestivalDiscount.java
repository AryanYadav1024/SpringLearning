package com.aryan.springdemo.vehicles;

public class FestivalDiscount implements discountService{
    @Override
    public String getDiscountMessage() {
        return "Festival Discount is: 20%";
    }
}
