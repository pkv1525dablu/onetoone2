package com.myAcc.controller;

import com.myAcc.payload.AddressDto;
import com.myAcc.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/api/address")
    public class AddressController {
        private AddressService addressService;

        public AddressController(AddressService addressService) {
            this.addressService = addressService;
        }

        @PostMapping    //localhost:8080/api/address
        public ResponseEntity<AddressDto> saveAddress(@RequestBody AddressDto addressDto) {
            AddressDto dto = addressService.saveAddress(addressDto);
            return  new ResponseEntity<>(dto, HttpStatus.CREATED);
        }

    }

