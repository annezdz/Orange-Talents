package com.example.api.cars.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Entity
@Table(name = "brands")

public class Brand {

    private String nome;

    @Id
    private Integer codigo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
    @JsonProperty (access =JsonProperty.Access.WRITE_ONLY)
    private Set<CarModel> carModel = new HashSet<>();

    @JsonIgnore
    public Set<CarModel> getCarModel(){
        return carModel;
    }

    @Deprecated
    public Brand() { }

    public Brand(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }


    public Integer getCodigo(){ return codigo; }

    public void setCodigo(Integer codigo){
        this.codigo = codigo;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCarModel(Set<CarModel> carModel){
        this.carModel = carModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(nome, brand.nome) && Objects.equals(codigo, brand.codigo) && Objects.equals(carModel,

                brand.carModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, codigo, carModel);
    }

    @Override
    public String toString() {
        return "Brand{" +
                "nome='" + nome + '\'' +
                ", codigo=" + codigo +
                ", carModel=" + getCarModel().stream().collect(Collectors.toSet()) +
                '}';
    }

    public <T> Set<T> mapCarModels(Function<CarModel, T> mapperFunction){
        return this.carModel
                .stream()
                .map(mapperFunction)
                .collect(Collectors.toSet());
    }

    public void addCarModels(List<CarModel> modelList) {
        this.carModel.addAll(modelList);
    }
}