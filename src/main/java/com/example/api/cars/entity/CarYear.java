package com.example.api.cars.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Entity
@Table(name="carYears")
public class CarYear {

    private String nome;

    @Id
    private String codigo;


    @ManyToOne(fetch = FetchType.LAZY)
    private CarModel carModel;

    @Deprecated
    public CarYear() {
    }

    public CarYear(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel){
        this.carModel = carModel;
    }

}
