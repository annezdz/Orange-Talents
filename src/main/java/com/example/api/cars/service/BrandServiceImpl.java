package com.example.api.cars.service;

import com.example.api.cars.connectors.ValueService;
import com.example.api.cars.entity.Brand;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class BrandServiceImpl {

    private final ValueService valueService;


    public BrandServiceImpl(ValueService valueService) {
        this.valueService = valueService;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public List<Brand> getBrands(){
        return valueService.getBrands();
    }

}
