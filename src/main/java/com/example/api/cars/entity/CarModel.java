package com.example.api.cars.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "carModels")
public class CarModel{

    private String nome;

    @Id
    private Integer codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;

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
}