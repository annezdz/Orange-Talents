package com.example.api.cars.connectors;

import com.example.api.cars.dto.CarModelResponseDto;
import com.example.api.cars.entity.Brand;
import com.example.api.cars.entity.CarModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(name = "parallelum" , url = "http://parallelum.com.br")
public interface ValueService {


    @GetMapping("/fipe/api/v1/carros/marcas")
    List<Brand> getBrands();

    @GetMapping("/fipe/api/v1/carros/marcas/{id}/modelos")
    CarModelResponseDto getTypes(@PathVariable("id") int id);




}
