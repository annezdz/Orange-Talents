package com.example.api.cars.service;

import com.example.api.cars.connectors.ValueService;
import com.example.api.cars.entity.Brand;
import com.example.api.cars.entity.CarModel;
import com.example.api.cars.repository.BrandRepository;
import com.example.api.cars.repository.CarModelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarModelServiceImpl implements CarModelService{

    private final ValueService valueService;

    private final BrandRepository brandRepository;

    private final CarModelRepository carModelRepository;

    public CarModelServiceImpl(ValueService valueService, BrandRepository brandRepository,
                               CarModelRepository carModelRepository) {
        this.valueService = valueService;
        this.brandRepository = brandRepository;
        this.carModelRepository = carModelRepository;
    }


    public List<CarModel> getCarModels(String nome) {
        var teste = brandRepository.findByNome(nome).getCodigo();
        return new ArrayList<>(valueService.getTypes(teste).getModelos());

    }

    public List<CarModel> testeCarModels(){
        brandRepository.findAll().forEach(c ->
                carModelRepository.saveAll(valueService.getTypes(c.getCodigo()).getModelos()));

        return carModelRepository.findAll();
    }
}






