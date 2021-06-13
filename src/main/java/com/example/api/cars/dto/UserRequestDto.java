package com.example.api.cars.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UserRequestDto {

    @NotBlank(message = "O nome não pode ser deixado em branco")
    @NotEmpty(message = "O nome não pode ser deixado em branco")
    private String name;

    @NotBlank(message = "O email não pode ser deixado em branco")
    @NotEmpty(message = "O email não pode ser deixado em branco")
    private String email;

    private String Cpf;

}
