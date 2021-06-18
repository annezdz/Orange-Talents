package com.example.api.cars.service;

import com.example.api.cars.connectors.ValueService;
import com.example.api.cars.entity.Brand;
import com.example.api.cars.repository.BrandRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService{

    private final ValueService valueService;
    private final BrandRepository brandRepository;


    public BrandServiceImpl(ValueService valueService, BrandRepository brandRepository) {
        this.valueService = valueService;
        this.brandRepository = brandRepository;
    }

    public List<Brand> getBrands(){

        return valueService.getBrands()
                .stream().map(brandRepository::save).collect(Collectors.toList());
    }

}
