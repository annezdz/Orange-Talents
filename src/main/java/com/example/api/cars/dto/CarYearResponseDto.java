package com.example.api.cars.dto;

import com.example.api.cars.entity.CarYear;

public class CarYearResponseDto {

    private String nome;

    private String codigo;

    public CarYearResponseDto(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public CarYear toModel(){
        return new CarYear(nome,codigo);
    }
}
