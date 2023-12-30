package com.myAcc.controller;

import com.myAcc.payload.UserDto;
import com.myAcc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/api/users")
public class UserController {
@Autowired
    private UserService userService;

    @PostMapping("/{id}")  // localhost:8080/api/users/1
    public ResponseEntity<UserDto> saveUser(@PathVariable("id") Long id,
                                            @RequestBody UserDto dto) {
        UserDto userSave = userService.saveUser(id,dto);
        return ResponseEntity.ok(userSave);
    }
}



