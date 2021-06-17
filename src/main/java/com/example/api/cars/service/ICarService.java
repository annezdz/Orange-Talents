package com.example.api.cars.service;

import com.example.api.cars.dto.CarRequestDto;
import com.example.api.cars.entity.Car;

public interface ICarService {

    Car create(CarRequestDto carRequestDto);
}
