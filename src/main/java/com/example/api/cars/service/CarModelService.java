package com.example.api.cars.service;

import com.example.api.cars.entity.Brand;
import com.example.api.cars.entity.CarModel;

import java.util.List;

public interface CarModelService {

    List<CarModel> getCarModels(String nome);

    List<CarModel> testeCarModels();
}
