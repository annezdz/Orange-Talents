package com.example.api.cars.service;

import com.example.api.cars.dto.UserRequestDto;
import com.example.api.cars.entity.User;
import com.example.api.cars.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)

public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void shouldCreateAnUser(){
        UserRequestDto user = new UserRequestDto("Anne Zimmermann","annezdz@hotmail.com",
                "043.815.299-95", LocalDate.of(2020,07,07));

        User createUser = user.toModel();
        when(userRepository.save(user.toModel())).thenReturn(createUser);

        var response = userService.create(user);
        assertEquals("annezdz@hotmail.com", response.getEmail());

    }

}
