package com.example.api.cars.controller;

import com.example.api.cars.entity.CarModel;
import com.example.api.cars.service.CarModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/models")
public class CarModelController {

    private final CarModelService carModelService;

    public CarModelController(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    @GetMapping("/{name}")
    public List<CarModel> getCarModels(@PathVariable String name){
        var modelCars = carModelService.getCarModels(name);
        return modelCars;
    }

    @GetMapping("/criar/{brand}")
    public ResponseEntity<?> criar(@PathVariable() String brand) {
        return ResponseEntity.ok(carModelService.saveCarModel(brand));
    }
}

