package com.example.api.cars.dto;

import com.example.api.cars.entity.Car;

import java.util.Objects;

public class CarResponseDto {

    private final int id;
    private final String brand;
    private final String carModel;
    private final String carYear;

    public CarResponseDto(Car car) {
        this.id = car.getId();
        this.brand = car.getBrand();
        this.carModel = car.getCarModel();
        this.carYear = car.getCarYear();
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarYear() {
        return carYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarResponseDto that = (CarResponseDto) o;
        return Objects.equals(brand, that.brand) && Objects.equals(carModel, that.carModel) && Objects.equals(carYear, that.carYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, carModel, carYear);
    }

    @Override
    public String toString() {
        return "CarResponseDto{" +
                "brand:'" + brand + '\'' +
                ",type:'" + carModel + '\'' +
                ",year:'" + carYear + '\'' +
                '}';
    }
}
