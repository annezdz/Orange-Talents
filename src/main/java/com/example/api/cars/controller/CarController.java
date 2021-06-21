package com.example.api.cars.controller;

import com.example.api.cars.entity.Brand;
import com.example.api.cars.repository.BrandRepository;
import com.example.api.cars.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    private final CarService carService;
    private final BrandRepository repository;

    public CarController(CarService carService, BrandRepository repository) {
        this.carService = carService;
        this.repository = repository;
    }

    @GetMapping("/create")
    public ResponseEntity<?> create() {
        return ResponseEntity.ok(carService.saveCarModel());
    }


//    @GetMapping
//    public ResponseEntity<?> getListBrandsTest(){
//        List<Brand> brands = carService.findAll();
//        return ResponseEntity.ok(brands);
//    }
}
