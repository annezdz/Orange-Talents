package com.example.api.cars.controller;

import com.example.api.cars.service.BrandServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandController {

    private final BrandServiceImpl brandService;

    public BrandController(BrandServiceImpl brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<?> findBrands() {
        return ResponseEntity.ok(brandService.getBrands());
    }

}
