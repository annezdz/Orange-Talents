package com.example.api.cars.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "brands")

public class Brand {

    private String nome;

    @Id
    private Integer codigo;

    @OneToMany
    private List<CarModel> carList;

    @Deprecated
    public Brand() { }

    public Brand(String nome, Integer codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public List<CarModel> getCarList() {
        return carList;
    }
}