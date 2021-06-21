package com.example.api.cars.service;

import com.example.api.cars.entity.Brand;
import com.example.api.cars.entity.CarModel;
import com.example.api.cars.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final BrandRepository brandRepository;
    private final CarModelService carModelService;

    public CarServiceImpl(BrandRepository brandRepository, CarModelService carModelService) {
        this.brandRepository = brandRepository;
        this.carModelService = carModelService;
    }

    @Override
    public List<Brand> findAll() {
        var getBrands = brandRepository.findAll();
       return getBrands;
    }

    public List<CarModel> saveCarModel() {
        return carModelService.saveCarModel("Agrale");
    }
}


