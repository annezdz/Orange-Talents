package com.example.api.cars.entity;

import com.example.api.cars.dto.UserResponseDto;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void shouldCreateANewUser(){
        User user = new User("Anne Zimmermann","annezdz@hotmail.com","909.574.160-59",
                LocalDate.of(1985,07,28));
        assertEquals("Anne Zimmermann", user.getName());
        assertEquals("annezdz@hotmail.com", user.getEmail());
        assertEquals("909.574.160-59", user.getCpf());
        assertEquals(LocalDate.of(1985,07,28), user.getBirthday());

    }

    @Test
    public void testEquals(){
        User user = new User();
        assertEquals(new User(),user);
    }

    @Test
    public void testHashCode(){
        assertEquals(923521,(new User().hashCode()));
    }

    @Test
    public void testToString(){
        assertEquals("User{name:'null', email:'null',cpf:'null',birthday:null}",
                (new User()).toString());
    }

    @Test
    public void shouldTwoUsersInstanceNotBeEqualExceptIfEmpty(){
        User user1 = new User("Anne Zimmermann","annezdz@hotmail.com","909.574.160-59",
                LocalDate.of(1985,07,28));
        User user2 = new User("Anne Zimmermann","annezdz1@hotmail.com","203.571.970-46",
                LocalDate.of(1985,07,28));
        User user3 = new User();
        User user4 = new User();
        assertNotEquals(user1.hashCode(),user2.hashCode());
        assertNotEquals(user3.hashCode(),user1.hashCode());
        assertEquals(user3.hashCode(),user4.hashCode());
    }

    @Test
    public void shouldTwoIdenticalAndBeEqual(){
        User user1 = new User("Anne Zimmermann","annezdz@hotmail.com","909.574.160-59",
                LocalDate.of(1985,07,28));
        User user2 = new User("Anne Zimmermann","annezdz@hotmail.com","909.574.160-59",
                LocalDate.of(1985,07,28));
        assertEquals(user1.hashCode(),user2.hashCode());
        assertEquals(user1.getCpf(),user2.getCpf());
    }

    @Test
    public void shouldGetAnIde() throws ParseException {
        User actual = new User();
        assertEquals(0, actual.getId());

    }






}
