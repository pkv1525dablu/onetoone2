package com.user.controller;

import com.user.payload.UserDto;
import com.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users2")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/{id}") // localhost:8080/api/users2/1
    public ResponseEntity<UserDto> createUser(@PathVariable("id") Long id,
                                            @RequestBody UserDto userDto) {
        UserDto savedUser = userService.createUser(id, userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

}
