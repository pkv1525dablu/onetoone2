package com.myAcc.service.impl;

import com.myAcc.entities.User;
import com.myAcc.exception.UserNotFoundException;
import com.myAcc.payload.UserDto;
import com.myAcc.repository.UserRepository;
import com.myAcc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
@Autowired
    private  UserRepository userRepository;



    @Override
    public UserDto saveUser(Long id, UserDto userDto) {

        User user = userRepository.findById(id).orElseThrow(
                     () -> new UserNotFoundException("User Id  " + id + " not found"));

        user.setName(userDto.getName());
        User userSave = userRepository.save(user);

        //  entity to dto
        UserDto dto = new UserDto();
        dto.setId(userSave.getId());
        dto.setName(userSave.getName());
        return dto;
    }
}

