package com.example.api.cars.dto;

import com.example.api.cars.entity.Car;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CarRequestDto {


    @NotBlank(message = "Brand is required")
    @NotEmpty(message = "Brand is required")
    private String brand;

    @NotBlank(message = "Type is required")
    @NotEmpty(message = "Type is required")
    private String type;

    @NotBlank(message = "Year is required")
    @NotEmpty(message = "Year is required")
    private String year;

    public CarRequestDto() { }

    public CarRequestDto(String brand, String type, String year){
        this.brand = brand;
        this.type = type;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getYear() {
        return year;
    }

    public Car toModel(){
        return new Car(brand,type,year);
    }
}
