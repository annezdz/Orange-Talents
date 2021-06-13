package com.example.api.cars.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Date;

public class UserRequestDto {

    @NotBlank(message = "Name is required")
    @NotEmpty(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @NotEmpty(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Cpf is required")
    @NotEmpty(message = "Cpf is required")
    @CPF(message = "Cpf should be valid")
    private String cpf;

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

}
