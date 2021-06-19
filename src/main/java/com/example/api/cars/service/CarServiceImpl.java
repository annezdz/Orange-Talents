package com.example.api.cars.service;

import com.example.api.cars.entity.Brand;
import com.example.api.cars.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final BrandRepository brandRepository;

    public CarServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> findAll() {
        var getBrands = brandRepository.findAll();
       return getBrands;
    }
}


