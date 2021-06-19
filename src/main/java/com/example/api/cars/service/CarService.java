package com.example.api.cars.service;

import com.example.api.cars.entity.Brand;
import com.example.api.cars.repository.BrandRepository;

import java.util.List;

public interface CarService {

    List<Brand> findAll();
}
