package com.user.service.impl;

import com.user.entities.User;
import com.user.exception.UserNotFoundException;
import com.user.payload.UserDto;
import com.user.repository.UserRepository;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class UserServiceImpl implements UserService {
        @Autowired
        private UserRepository userRepository;

        @Override
        public UserDto createUser(Long id, UserDto userDto) {

            User user = userRepository.findById(id).orElseThrow(
                    () -> new UserNotFoundException("User  not found" + id));

            user.setName(userDto.getName());
            User save = userRepository.save(user);

            // entity to dto
            UserDto dto = new UserDto();
            dto.setId(save.getId());
            dto.setName(save.getName());

            return dto;

        }
    }
