package com.example.api.cars.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carModels")

public class CarModel {

    private String nome;

    @Id
    private String codigo;

    @ManyToOne()
    private Brand brand;

    public CarModel() {
    }

    public CarModel(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public Brand getBrand() {
        return brand;
    }
}
