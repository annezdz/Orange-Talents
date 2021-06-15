package com.example.api.cars.service;

import com.example.api.cars.dto.UserRequestDto;
import com.example.api.cars.entity.User;
import com.example.api.cars.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(UserRequestDto userRequestDto) {

        return userRepository.save(userRequestDto.toModel());
    }




}
