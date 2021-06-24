package com.example.api.cars.service;

import com.example.api.cars.connectors.ValueService;
import com.example.api.cars.dto.CarYearResponseDto;
import com.example.api.cars.entity.CarYear;
import com.example.api.cars.repository.BrandRepository;
import com.example.api.cars.repository.CarModelRepository;
import com.example.api.cars.repository.CarYearRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarYearServiceImpl implements CarYearService {

    private final ValueService valueService;

    private final CarModelRepository carModelRepository;

    private final BrandRepository brandRepository;

    private final CarYearRepository carYearRepository;

    public CarYearServiceImpl(ValueService valueService, CarModelRepository carModelRepository,
                              BrandRepository brandRepository, CarYearRepository carYearRepository) {
        this.valueService = valueService;
        this.carModelRepository = carModelRepository;
        this.brandRepository = brandRepository;
        this.carYearRepository = carYearRepository;
    }

//    public List<CarYear> createYear(int brandId, int modelId) {
//
//        var carModel = carModelRepository.findById(modelId).get();
//        var carYears = carModelRepository.findByCodigoAndBrandCodigo(brandId, modelId)
//                .map(c -> valueService.getCarYears(c.getBrand().getCodigo(), c.getCodigo()).stream()
//                        .map(CarYearResponseDto::toModel).collect(Collectors.toList()))
//                .orElseThrow();
//
//        carYears.forEach(c -> c.setCarModel(carModelRepository.findById(modelId).get()));
//        carYearRepository.saveAll(carYears);
//
//        carModel.addCarYears(carYears);
//        carModelRepository.save(carModel);
//
//        return carYears;
//    }

    public List<CarYear> saveCarYears(String brand, String model) {
        var carBrand = brandRepository.findByNome(brand);
        var carModel = carModelRepository.findByNome(model);
        var carYearsList = valueService.getCarYears(carBrand.getCodigo(), carModel.getCodigo())
                .stream().map(CarYearResponseDto::toModel).collect(Collectors.toList());

        carYearsList.forEach(c -> c.setCarModel(carModel));
        carYearRepository.saveAll(carYearsList);
        carModel.addCarYears(carYearsList);
        carModelRepository.save(carModel);
        return carYearsList;
    }
}

