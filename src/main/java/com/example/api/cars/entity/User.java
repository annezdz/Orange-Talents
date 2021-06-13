package com.example.api.cars.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Email
    private String email;

    @Column(nullable = false)
    @CPF
    private String Cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false)
    private Date birthday;

    @Deprecated
    public User() { }

    public User(int id, String name, String email, String cpf, Date birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        Cpf = cpf;
        this.birthday = birthday;
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
        return Cpf;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", Cpf='" + Cpf + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(Cpf, user.Cpf) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, Cpf, birthday);
    }
}
