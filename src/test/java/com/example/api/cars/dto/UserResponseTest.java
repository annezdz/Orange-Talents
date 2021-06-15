package com.example.api.cars.dto;

import com.example.api.cars.entity.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.text.ParseException;
import java.time.LocalDate;

public class UserResponseTest {

    @Test
    public void shouldCreateResponseDtoInstance() throws ParseException {
        UserResponseDto actual = new UserResponseDto(new User());
        assertNull(actual.getName());
        assertNull(actual.getEmail());
        assertNotNull(actual.getCpf());
        assertNull(actual.getBirthday());
        assertTrue(true);
    }

    @Test
    public void shouldCreateResponse() throws ParseException {
        UserResponseDto actual = new UserResponseDto(new User("teste","teste@teste.com","90957416059",
                LocalDate.of(2020,07,07)));
        assertEquals("teste",actual.getName());
        assertEquals("teste@teste.com", actual.getEmail());
        assertEquals(LocalDate.of(2020,07,07),actual.getBirthday());
        assertEquals("909.574.160-59", actual.getCpf());
    }

    @Test
    public void shouldGetAnIde() throws ParseException {
        UserResponseDto actual = new UserResponseDto(new User());
        assertEquals(0, actual.getId());
    }

    @Test
    public void shouldThrowAnException() throws ParseException {
        assertThrows(ParseException.class, () -> new UserResponseDto(new User
                ("teste","teste","909.574.16059",
                LocalDate.of(1985,07,28))));
    }
}
