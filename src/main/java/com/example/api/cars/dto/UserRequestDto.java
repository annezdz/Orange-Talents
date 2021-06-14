package com.example.api.cars.dto;

import com.example.api.cars.entity.User;
import com.example.api.cars.validator.UniqueUser;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class UserRequestDto {

    @NotBlank(message = "Name is required")
    @NotEmpty(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @NotEmpty(message = "Email is required")
    @Email(message = "Email should be valid")
    @UniqueUser
    private String email;

    @NotBlank(message = "Cpf is required")
    @NotEmpty(message = "Cpf is required")
    @CPF(message = "Cpf should be valid")
    @UniqueUser
    private String cpf;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private LocalDate birthday;

    @Deprecated
    public UserRequestDto() { }

    public UserRequestDto(String name, String email, String cpf, LocalDate birthday){
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthday = birthday;
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

    public User toModel(){
        return new User(name,email,cpf,birthday);
    }

}
