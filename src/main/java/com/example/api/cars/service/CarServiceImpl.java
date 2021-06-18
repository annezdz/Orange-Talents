package com.example.api.cars.service;

import com.example.api.cars.dto.CarRequestDto;
import com.example.api.cars.entity.Car;
import com.example.api.cars.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final BrandService brandService;

    private final CarRepository carRepository;


    public CarServiceImpl(BrandService brandService, CarRepository carRepository) {
        this.brandService = brandService;
        this.carRepository = carRepository;
    }


    public Car create(CarRequestDto carRequestDto) {
        return null;
    }
}


