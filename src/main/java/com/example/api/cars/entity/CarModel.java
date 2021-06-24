package com.example.api.cars.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Entity
@Table(name = "carModels")
public class CarModel{

    private String nome;

    @Id
    private Integer codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "carModel")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<CarYear> carYears = new HashSet<>();

    @JsonIgnore
    public Set<CarYear> getCarYears(){
        return carYears;
    }

    @Deprecated
    public CarModel() {
    }

    public CarModel(String nome, Integer codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand){
        this.brand = brand;
    }

    public void setCarYears(Set<CarYear> carYears){
        this.carYears = carYears;
    }

    public <T> Set <T> mapCarYears(Function<CarYear, T> mapperFunction){
        return this.carYears
                .stream()
                .map(mapperFunction)
                .collect(Collectors.toSet());
    }

    public void addCarYears(List<CarYear> modelList){
        this.carYears.addAll(modelList);
    }
}