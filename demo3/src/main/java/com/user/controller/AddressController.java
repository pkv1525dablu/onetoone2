package com.user.controller;

import com.user.payload.AddressDto;
import com.user.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address3")
public class AddressController {
   @Autowired
    private AddressService addressService;

    @PostMapping  // localhost:8080/api/address3
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto) {
        AddressDto createdAddress = addressService.createAddress(addressDto);
        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
    }
}
