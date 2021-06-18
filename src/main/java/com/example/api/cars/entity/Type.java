package com.example.api.cars.entity;

import javax.persistence.Id;

public class Type {

    private String nome;

    @Id
    private String codigo;

    public Type(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }
}
