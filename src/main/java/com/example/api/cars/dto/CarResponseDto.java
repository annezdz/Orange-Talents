package com.example.api.cars.dto;

import com.example.api.cars.entity.Car;

import java.util.Objects;

public class CarResponseDto {

    private final int id;
    private final String brand;
    private final String type;
    private final String year;

    public CarResponseDto(Car car) {
        this.id = car.getId();
        this.brand = car.getBrand();
        this.type = car.getType();
        this.year = car.getYear();
    }

    public int getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarResponseDto that = (CarResponseDto) o;
        return Objects.equals(brand, that.brand) && Objects.equals(type, that.type) && Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, type, year);
    }

    @Override
    public String toString() {
        return "CarResponseDto{" +
                "brand:'" + brand + '\'' +
                ",type:'" + type + '\'' +
                ",year:'" + year + '\'' +
                '}';
    }
}
