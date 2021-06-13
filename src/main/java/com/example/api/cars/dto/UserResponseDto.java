package com.example.api.cars.dto;

import com.example.api.cars.entity.User;

import java.time.LocalDate;

public class UserResponseDto {

    private final int id;
    private final String name;
    private final String email;
    private final String cpf;
    private final LocalDate birthday;

    public UserResponseDto(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.birthday = user.getBirthday();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
