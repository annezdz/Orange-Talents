package com.example.api.cars.controller;

import com.example.api.cars.entity.Brand;
import com.example.api.cars.entity.CarModel;
import com.example.api.cars.service.CarModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/models")
public class CarModelController {

    private CarModelService carModelService;

    public CarModelController(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    @GetMapping("/{brand}")
    public List<CarModel> getCarModels(@PathVariable String brand){
        var modelCars = carModelService.getCarModels(brand);
        return modelCars;
    }

    @GetMapping("/criar")
    public ResponseEntity<?> criar() {
        return ResponseEntity.ok(carModelService.testeCarModels());
    }
}