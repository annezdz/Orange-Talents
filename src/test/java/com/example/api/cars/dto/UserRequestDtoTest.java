package com.example.api.cars.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class UserRequestDtoTest {

    @Test
    public void shouldRequestAnUser(){
        UserRequestDto actual = new UserRequestDto();
        assertTrue(true);
    }

    @Test
    public void shouldRequestAndWithParameters(){
        UserRequestDto actual = new UserRequestDto("Anne Zimmermann","annezdz@hotmail.com","909.574.160-59",
                LocalDate.of(1985,07,28));
        assertEquals("Anne Zimmermann", actual.getName());
        assertEquals("annezdz@hotmail.com", actual.getEmail());
        assertEquals("909.574.160-59", actual.getCpf());
        assertEquals(LocalDate.of(1985,07,28),actual.getBirthday());
    }

    @Test
    public void shouldReturnAModel(){
        UserRequestDto actual = new UserRequestDto("Anne Zimmermann","annezdz@hotmail.com",
                "909.574.160-59",
                LocalDate.of(1985,07,28));
        assertEquals("Anne Zimmermann", actual.toModel().getName());
        assertEquals("annezdz@hotmail.com", actual.toModel().getEmail());
        assertEquals("90957416059", actual.toModel().getCpf());
        assertEquals(LocalDate.of(1985,07,28),actual.toModel().getBirthday());
        assertTrue(true);
    }

    @Test
    public void shouldGetPropertiesFromUserRequestDto(){
        UserRequestDto actual = new UserRequestDto("Anne Zimmermann","annezdz@hotmail.com",
                "909.574.160-59",
                LocalDate.of(1985,07,28));
        assertEquals("Anne Zimmermann", actual.getName());
        assertEquals("annezdz@hotmail.com", actual.getEmail());
        assertEquals("909.574.160-59", actual.getCpf());
        assertTrue(true);
    }
}
