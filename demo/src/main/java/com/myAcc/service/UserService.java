package com.myAcc.service;

import com.myAcc.payload.UserDto;

public interface UserService {
    public UserDto saveUser(Long id, UserDto userDto);

}
