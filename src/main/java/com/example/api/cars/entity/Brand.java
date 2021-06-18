package com.example.api.cars.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Brand {

    private final String nome;

    @Id
    private final Integer codigo;

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


}
