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
    public void shouldCreateResponse()  {
        UserResponseDto actual = null;
        try {
            actual = new UserResponseDto
                    (new User("Anne Zimmermann","annezdz@hotmail.com","90957416059",
                    LocalDate.of(1985,07,28)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals("Anne Zimmermann",actual.getName());
        assertEquals("annezdz@hotmail.com",actual.getEmail());
        try {
            assertEquals("909.574.160-59", actual.formatCpf(actual.getCpf()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(LocalDate.of(1985,07,28),actual.getBirthday());
    }

    @Test
    public void shouldGetAnIde() throws ParseException {
        UserResponseDto actual = new UserResponseDto(new User());
        assertEquals(0, actual.getId());

    }
}
