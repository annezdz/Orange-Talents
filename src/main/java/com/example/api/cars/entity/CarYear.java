package com.example.api.cars.entity;

import javax.persistence.*;

@Entity
@Table(name="carYears")
public class CarYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
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
