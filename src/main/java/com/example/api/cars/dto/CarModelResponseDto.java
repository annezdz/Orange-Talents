package com.example.api.cars.dto;

import com.example.api.cars.entity.CarModel;

import java.util.List;

public class CarModelResponseDto {

    private List<CarModel> modelos;

    public CarModelResponseDto() {
    }

    public CarModelResponseDto(List<CarModel> modelos) {
        this.modelos = modelos;
    }

    public List<CarModel> getModelos() {
        return modelos;
    }
}
