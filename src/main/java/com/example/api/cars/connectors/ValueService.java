package com.example.api.cars.connectors;

import com.example.api.cars.dto.FipeReponseDto;
import com.example.api.cars.entity.Brand;
import com.example.api.cars.entity.Car;
import com.example.api.cars.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.IntStream;

@Component
@FeignClient(name = "parallelum" , url = "http://parallelum.com.br")
public interface ValueService {


    @GetMapping("/fipe/api/v1/carros/marcas")
    List<Brand> getBrands();

    @GetMapping("/fipe/api/v1/carros/marcas/{id}/modelos")
    List<Type> getTypes(@PathVariable("id") int id);



}
