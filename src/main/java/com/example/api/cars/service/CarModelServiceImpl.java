package com.example.api.cars.service;

import com.example.api.cars.connectors.ValueService;
import com.example.api.cars.entity.Brand;
import com.example.api.cars.entity.CarModel;
import com.example.api.cars.repository.BrandRepository;
import com.example.api.cars.repository.CarModelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

        var marcas = brandRepository.findAll();

        var modelos = valueService.getTypes(marcas.get(1).getCodigo()).getModelos();
        carModelRepository.saveAll(modelos);
        return modelos;

    }


    public List<CarModel> testeCarModels(){
        var marcas = brandRepository.findAll();
        var modelos = valueService.getTypes(marcas.get(0).getCodigo()).getModelos();
        for (var car : modelos) {
            carModelRepository.save(car);
        }
//        carModelRepository.saveAll(modelos);
//        marcas.forEach(c -> carModelRepository.saveAllAndFlush(valueService.getTypes(c.getCodigo()).getModelos()));

        var response = carModelRepository.findAll();
        return response;
    }

    public List<CarModel> saveCarModel(String name){
        var brand = brandRepository.findByNome(name);
        var carModelsList = valueService.getTypes(brand.getCodigo()).getModelos();
        carModelsList.forEach(c -> c.setBrand(brand));
        carModelRepository.saveAll(carModelsList);

        brand.addCarModels(carModelsList);
        brandRepository.save(brand);

        return carModelsList;

//        return valueService.getBrands()
//                .stream().map(brandRepository::save).collect(Collectors.toList());
    }
}






