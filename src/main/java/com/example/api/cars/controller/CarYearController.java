package com.example.api.cars.controller;

import com.example.api.cars.entity.CarYear;
import com.example.api.cars.service.CarYearService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/years")
public class CarYearController {

    private final CarYearService carYearService;

    public CarYearController(CarYearService carYearService) {
        this.carYearService = carYearService;
    }

//    @GetMapping("/listar/{brandId}/{modelId}")
//    public List<CarYear> getYears(@PathVariable() int brandId, @PathVariable() int modelId) {
//        return carYearService.createYear(brandId, modelId);
//    }

    @GetMapping("/salvar/{brandId}/{modelId}")
    public List<CarYear> saveYears(@PathVariable() String brandId, @PathVariable() String modelId) {
        return carYearService.saveCarYears(brandId, modelId);
    }
}
