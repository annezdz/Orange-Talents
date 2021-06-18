package com.example.api.cars.service;

import com.example.api.cars.dto.CarRequestDto;
import com.example.api.cars.entity.Car;
import com.example.api.cars.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;


    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public Car create(CarRequestDto carRequestDto) {
        return null;
    }
}


