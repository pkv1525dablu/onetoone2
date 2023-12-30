package com.user.service;


import com.user.payload.UserDto;

public interface UserService {
    public UserDto createUser(Long id, UserDto userDto);
}
