package com.example.api.cars.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String carModel;

    @Column(nullable = false)
    private String carYear;

    @Deprecated
    public Car() { }

    public Car(String brand, String carModel, String carYear) {
        this.brand = brand;
        this.carModel = carModel;
        this.carYear = carYear;
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
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) && Objects.equals(carModel, car.carModel) && Objects.equals(carYear, car.carYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, carModel, carYear);
    }

    @Override
    public String toString() {
        return "Car{" +
                ", brand='" + brand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carYear='" + carYear + '\'' +
                '}';
    }
}
