package com.user.controller;

import com.user.payload.UserDto;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users3")
public class UserController {
        @Autowired
    private  UserService userService;


    @PostMapping("/{id}") // localhost:8080/api/users3/1
    public ResponseEntity<UserDto> createUser(@PathVariable("id") Long id,
                                              @RequestBody UserDto userDto) {
        UserDto createdUser = userService.createUser(id, userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
