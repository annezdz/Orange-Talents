package com.example.api.cars.service;


import com.example.api.cars.connectors.ValueService;
import com.example.api.cars.entity.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelCarImpl {

    private final ValueService valueService;

    private List<Brand> brands;

    public ModelCarImpl(ValueService valueService, List<Brand> brands) {
        this.valueService = valueService;
        this.brands = brands;
    }
}





