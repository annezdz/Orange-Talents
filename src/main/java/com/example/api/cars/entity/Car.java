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
    private String type;

    @Column(nullable = false)
    private String year;

    @Deprecated
    public Car() { }

    public Car(String brand, String type, String year) {
        this.brand = brand;
        this.type = type;
        this.year = year;
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
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) && Objects.equals(type, car.type) && Objects.equals(year, car.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, type, year);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand:'" + brand + '\'' +
                ",type:'" + type + '\'' +
                ",year:'" + year + '\'' +
                '}';
    }

}
