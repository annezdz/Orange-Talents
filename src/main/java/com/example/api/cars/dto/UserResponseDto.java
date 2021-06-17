package com.example.api.cars.dto;

import com.example.api.cars.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Objects;

public class UserResponseDto {

    private final int id;
    private final String name;
    private final String email;
    private final String cpf;
    private final LocalDate birthday;


    public UserResponseDto(User user) throws ParseException {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.cpf = formatCpf(user.getCpf());
        this.birthday = user.getBirthday();
    }

    public UserResponseDto(int id, String name, String email, String cpf, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthday = birthday;
    }

    public Integer getId() {
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

    public String formatCpf(String document) throws ParseException {
        try{
            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(document);
        } catch (ParseException e) {
            throw new ParseException(e.getMessage(),0);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name:'" + name + '\'' +
                ",email:'" + email + '\'' +
                ",cpf:'" + cpf + '\'' +
                ",birthday:" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResponseDto that = (UserResponseDto) o;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(cpf, that.cpf) && Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, cpf, birthday);
    }
}
