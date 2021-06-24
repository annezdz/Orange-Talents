package com.example.api.cars.service;

import com.example.api.cars.entity.CarModel;
import com.example.api.cars.entity.CarYear;

import java.util.List;

public interface CarYearService {

    List<CarYear> saveCarYears(String nome, String ano);
//    List<CarYear> createYear(int brandId, int modelId);

}
