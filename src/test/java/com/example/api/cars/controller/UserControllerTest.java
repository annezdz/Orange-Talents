package com.example.api.cars.controller;

import com.example.api.cars.config.SpringTestConfig;
import com.example.api.cars.dto.UserRequestDto;
import com.example.api.cars.dto.UserResponseDto;
import com.example.api.cars.entity.User;
import com.example.api.cars.repository.UserRepository;
import com.example.api.cars.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {SpringTestConfig.class})
@AutoConfigureMockMvc
public class UserControllerTest {

    private User user;

    @Mock
    private UriComponentsBuilder uriComponentsBuilder;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @Autowired
    private ObjectMapper mapper;

    private UserRequestDto userRequest;

    @BeforeEach
    public void setup(){
        UserRequestDto userRequestDto  = new UserRequestDto("Anne Zimmermann","annezdz@hotmail.com",
                "043.815.299-95", LocalDate.of(2020,07,07));
        this.userRequest = userRequestDto;
    }

    @AfterEach
    public void rollback() {
        userRepository.deleteAll();
    }

    @Test
    public void shouldReturnBadRequestWhenUserAlreadyExists() throws Exception {
        User user = this.userRequest.toModel();
        userRepository.save(user);

        mockMvc.perform(post("/api/v1/users")
        .content(mapper.writeValueAsString(userRequest))
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void test() throws Exception {
        UserController userController = new UserController(userService);

        UserRequestDto testRequest  = new UserRequestDto("Anne Zimmermann","annezdz251@hotmail.com",
                "278.378.548-02", LocalDate.of(2020,07,07));

        User user1 = testRequest.toModel();

       UserResponseDto responseDto = new UserResponseDto(0,"Anne Zimmermann","annezdz251@hotmail.com",
               "278.378.548-02", LocalDate.of(2020,07,07));

        when(userService.create(testRequest)).thenReturn(user1);

        URI uri = UriComponentsBuilder.fromPath("/api/v1/users/{id}").buildAndExpand(user1.getId())
                .toUri();
        var response = userController.create(testRequest, UriComponentsBuilder.fromUri(uri));

        assertEquals(responseDto.toString(), response.getBody().toString());

    }
}
