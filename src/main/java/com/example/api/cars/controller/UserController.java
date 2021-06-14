package com.example.api.cars.controller;

import com.example.api.cars.dto.UserRequestDto;
import com.example.api.cars.dto.UserResponseDto;
import com.example.api.cars.exception.BirthdayException;
import com.example.api.cars.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UserRequestDto userRequestDto,
                                    UriComponentsBuilder uriComponentsBuilder) {

        var createdUser = userService.create(userRequestDto);
        URI location = uriComponentsBuilder
                .path("api/v1/users/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();
        return ResponseEntity.created(location).body(new UserResponseDto(createdUser));
    }
}
