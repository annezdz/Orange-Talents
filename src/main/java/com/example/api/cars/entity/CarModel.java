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
        this.carYears=carYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarModel carModel = (CarModel) o;
        return Objects.equals(nome, carModel.nome) && Objects.equals(codigo, carModel.codigo) && Objects.equals(brand, carModel.brand) && Objects.equals(carYears, carModel.carYears);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, codigo, brand, carYears);
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

    @Override
    public String toString() {
        return "CarModel{" +
                "nome='" + nome + '\'' +
                ", codigo=" + codigo +
                ", brand=" + brand +
                ", carYears=" + getCarYears().stream().collect(Collectors.toSet()) +
                '}';
    }
}