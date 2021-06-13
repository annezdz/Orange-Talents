package com.example.api.cars.service;

import com.example.api.cars.dto.UserRequestDto;
import com.example.api.cars.dto.UserResponseDto;
import com.example.api.cars.entity.User;

public interface UserService {

    User create(UserRequestDto userRequestDto);

}
